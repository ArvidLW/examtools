package thoughtworks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TWorks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            try {
                if (s.length() > 0) {
                    CourtManage.dealRequest(s);
                } else {
                    String income = CourtManage.getIncome();
                    System.out.println(income);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 场地
 */
class Court {
    //单价记录：workady,与weekend分别包含时间和价格条目Integer[0,1,2]分别为起始时间，终，单价。
    public static Map<String, List<Integer[]>> unitPrice = new HashMap<>();
    //构造代码块
    static {
        //初始化价格
        List<Integer[]> workdayPrice = new ArrayList<>();
        workdayPrice.add(new Integer[]{9, 12, 30});
        workdayPrice.add(new Integer[]{12, 18, 50});
        workdayPrice.add(new Integer[]{18, 20, 80});
        workdayPrice.add(new Integer[]{20, 22, 60});
        unitPrice.put("workday", workdayPrice);
        List<Integer[]> weekendPrice = new ArrayList<>();
        weekendPrice.add(new Integer[]{9, 12, 40});
        weekendPrice.add(new Integer[]{12, 18, 50});
        weekendPrice.add(new Integer[]{18, 22, 60});
        unitPrice.put("weekend", weekendPrice);
    }
}

/**
 * 场地管理
 */
class CourtManage {
    private static int income = 0;
    //场地状态记录:用HashMap保存对应场地，日期，时间段
    private static Map<String, Map<String, Map<String, Integer>>> courtState = new TreeMap<>();
    //使用情况记录,对应的是场地，与其相应记录和收入。String[] 记录时间、钱数、违约金标记
    private static Map<String, Map<String, List<String[]>>> useRecord = new TreeMap<>();
    //日期格式
    private static DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat weekformat = new SimpleDateFormat("EEEE");

    public static void dealRequest(String s) throws Exception {
        String[] req = s.split(" ");
        if (req.length == 5) {
            cancelCourt(req);
        } else if (req.length == 4) {
            bookCourt(req);
        } else {
            System.out.println("> Error: the booking is invalid!");
        }
    }

    public static void bookCourt(String[] req) throws Exception {
        //检查有没场地记录
        if (!courtState.containsKey(req[3])) {
            courtState.put(req[3], new TreeMap<>());
        }
        //检查相应的日期记录
        Map<String, Map<String, Integer>> courtUse = courtState.get(req[3]);
        if (!courtUse.containsKey(req[1])) {
            courtUse.put(req[1], new TreeMap<>());
        }
        Map<String, Integer> dateUse = courtUse.get(req[1]);
        //判断时间是否冲突
        String[] keys = dateUse.keySet().toArray(new String[0]);
        String[] reqTimeStrs = req[2].split("~");
        int[] reqTime = new int[]{Integer.valueOf(reqTimeStrs[0].split(":")[0]), Integer.valueOf(reqTimeStrs[1].split(":")[0])};
        if (reqTime[1] - reqTime[0] == 0) {
            System.out.println("Error: the booking is invalid!");
            return;
        }
        Boolean isConflict = false;
        for (int i = 0; i < keys.length; ++i) {
            String[] tmpTimeStrs = keys[i].split("~");
            int[] tmpTime = new int[]{Integer.valueOf(tmpTimeStrs[0].split(":")[0]), Integer.valueOf(tmpTimeStrs[1].split(":")[0])};
            if ((tmpTime[0] >= reqTime[0] && tmpTime[0] <= reqTime[1]) || (tmpTime[1] >= reqTime[0] && tmpTime[1] <= reqTime[1])) {
                isConflict = true;
                System.out.println("> Error: the booking conflicts with existing bookings!");
                break;
            }
        }
        //如果不冲突就加入状态与记录
        if (!isConflict) {
            int money = getPrice(isWeekend(req[1]), req[2]);
            dateUse.put(req[2], money);
            //记录进入useRecord
            if (!useRecord.containsKey(req[3])) {
                useRecord.put(req[3], new TreeMap<>());
            }
            Map<String, List<String[]>> courtRecord = useRecord.get(req[3]);
            if (!courtRecord.containsKey(req[1])) {
                courtRecord.put(req[1], new ArrayList<>());
            }
            List<String[]> strs = courtRecord.get(req[1]);
            strs.add(new String[]{req[2], String.valueOf(money), ""});
            System.out.println("> Success: the booking is accepted!");
        }
    }

    public static void cancelCourt(String[] req) throws Exception {
        //检查有没场地记录
        if (!courtState.containsKey(req[3])) {
            System.out.println("> Error: the booking being cancelled does not exist!");
            return;
        }
        //检查相应的日期记录
        Map<String, Map<String, Integer>> courtUse = courtState.get(req[3]);
        if (!courtUse.containsKey(req[1])) {
            System.out.println("> Error: the booking being cancelled does not exist!");
            return;
        }
        Map<String, Integer> dateUse = courtUse.get(req[1]);
        if (!dateUse.containsKey(req[2])) {
            System.out.println("> Error: the booking being cancelled does not exist!");
            return;
        }
        //计算违约金
        float rate = isWeekend(req[1]) ? 0.25f : 0.5f;
        int money = (int) (dateUse.get(req[2]) * rate);
        //更新场地状态
        dateUse.remove(req[2]);
        //更新money记录
        List<String[]> ls = useRecord.get(req[3]).get(req[1]);
        int flag = 0;
        for (int i = ls.size() - 1; i >= 0; --i) {
            String[] strs = ls.get(i);
            if (strs[0].equals(req[2]) && strs[2] != "违约金") {
                strs[1] = String.valueOf(money);
                strs[2] = "违约金";
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("> Success: the booking is accepted!");
        }
    }

    public static int getPrice(Boolean isWeekend, String timePeriod) {
        String[] tps = timePeriod.split("~");
        int[] timeps = new int[]{Integer.valueOf(tps[0].split(":")[0]), Integer.valueOf(tps[1].split(":")[0])};
        if (isWeekend) {
            List<Integer[]> weekendPrice = Court.unitPrice.get("weekend");
            return calPrice(weekendPrice, timeps);
        } else {
            List<Integer[]> workday = Court.unitPrice.get("workday");
            return calPrice(workday, timeps);
        }
    }

    private static int calPrice(List<Integer[]> weekPrice, int[] timeps) {
        for (int i = 0; i < weekPrice.size(); ++i) {
            Integer[] wp = weekPrice.get(i);
            if (wp[0] <= timeps[0] && wp[1] >= timeps[1]) {
                return wp[2] * (timeps[1] - timeps[0]);
            } else if (wp[0] <= timeps[0] && wp[1] > timeps[0]) {
                int price = (wp[1] - timeps[0]) * wp[2];
                return price + calPrice(weekPrice, new int[]{wp[1], timeps[1]});
            }
        }
        return 0;
    }

    private static boolean isWeekend(String dateStr) throws Exception {
        Date date = dateformat.parse(dateStr);
        String week = weekformat.format(date);
        switch (week) {
            case "星期一":
                return false;
            case "星期二":
                return false;
            case "星期三":
                return false;
            case "星期四":
                return false;
            case "星期五":
                return false;
            case "星期六":
                return true;
            case "星期日":
                return true;
            default:
                throw new Exception("没有匹配的星期");
        }
    }

    public static int calmoney() {
        return income;
    }

    public static String getIncome() {
        StringBuffer sb = new StringBuffer();
        sb.append("> 收入汇总\n> ---\n");
        Iterator<Map.Entry<String, Map<String, List<String[]>>>> urIt = useRecord.entrySet().iterator();
        int totalIncome = 0;
        totalIncome += getCourtIncome(sb, "A");
        sb.append("> \n");
        totalIncome += getCourtIncome(sb, "B");
        sb.append("> \n");
        totalIncome += getCourtIncome(sb, "C");
        sb.append("> \n");
        totalIncome += getCourtIncome(sb, "D");
        sb.append("> ---\n> 总计：" + totalIncome + "元\n");
        return sb.toString();
    }

    private static int getCourtIncome(StringBuffer sb, String courtName) {
        sb.append("> 场地：" + courtName + "\n");
        int income = 0;
        if (useRecord.containsKey(courtName)) {
            Map<String, List<String[]>> ucrdate = useRecord.get(courtName);
            Iterator<Map.Entry<String, List<String[]>>> ucrdateIt = ucrdate.entrySet().iterator();
            while (ucrdateIt.hasNext()) {
                Map.Entry<String, List<String[]>> ucrday = ucrdateIt.next();
                String date = ucrday.getKey();
                List<String[]> res = ucrday.getValue();
                Collections.sort(res, new InfoComparator());
                Iterator<String[]> ucrdayIt = res.iterator();
                while (ucrdayIt.hasNext()) {
                    String[] day = ucrdayIt.next();
                    income += Integer.valueOf(day[1]);
                    if (day[2] == "") {
                        sb.append("> " + date + " " + day[0] + " " + day[1] + "元\n");
                    } else {
                        sb.append("> " + date + " " + day[0] + " " + day[2] + " " + day[1] + "元\n");
                    }
                }
            }
        }
        sb.append("> 小计：" + income + "元\n");
        return income;
    }
}

/**
 * 数组排序比较，用于一天中的时间字串数组排序，升序
 */
class InfoComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (((String[]) o1)[0].compareTo(((String[]) o2)[0]) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}