package com.ajayhao.workshop.stream;

import com.ajayhao.mslab.core.util.JsonUtil;
import com.ajayhao.workshop.PersonVO;
import com.fasterxml.jackson.core.type.TypeReference;
import jodd.io.FileUtil;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * CollectorApiDemos
 * <p>
 * TODO
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2019/11/10 10:13
 */
public class CollectorApiDemos {

    private static List<PersonVO> persons;

    static {
        String jsonStr = null;
        try {
            String path = CollectorApiDemos.class.getResource("/").getPath();
            jsonStr = FileUtil.readString(path+"person.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        persons = JsonUtil.parse(jsonStr,new TypeReference<List<PersonVO>>(){});
    }


    public static void main(String[] args){
        CollectorApiDemos demo = new CollectorApiDemos();
        demo.toList();
        demo.toSet();
        demo.toMap();
        demo.toMapWithMerge();
        demo.filterWithSort();
        demo.logicStat();
        demo.numberStat();
        demo.skipAndPeek();
        demo.groupingBy();
        demo.groupingBySpecificType();
        demo.partitioningBy();
        demo.groupingBySum();
    }


    /**
     * toList
     */
    public void toList() {
        System.out.println("### build to list");
        List<Date> dateList = Stream.generate(Date::new).limit(10).collect(Collectors.toList());

        print(dateList);
    }


    /**
     * toSet
     */
    public void toSet() {
        System.out.println("### build to set");
        HashSet<Date> dateSet = Stream.generate(Date::new)
                .limit(10)
                .collect(Collectors.toCollection(HashSet::new));

        print(dateSet);
    }

    /**
     * toMap
     */
    public void toMap() {
        System.out.println("### build to map");
        Map<String, String> mapData = Stream.of("2019-01-01","2018-10-31","2017-02-15")
                .collect(Collectors.toMap(e -> e.split("-")[0], Function.identity()));
        print(mapData);
    }

    /**
     * toMap
     */
    public void toMapWithMerge() {
        System.out.println("### build to merged map");
        Map<String, String> mapData = Stream.of("2018-01-01","2018-10-31","2018-02-15")
                .collect(Collectors.toMap(e -> e.split("-")[0],
                        Function.identity(),
                        (v1,v2) -> v1 + "," + v2));
        print(mapData);
    }


    /**
     * 筛选及排序
     */
    public void filterWithSort() {
        System.out.println("### filter and sort");
        List<PersonVO> newPersons = persons.stream()
                .filter(p -> "Hou".equals(p.getTeam()))
                .sorted(Comparator.comparingInt(PersonVO::getId).reversed())
                    .collect(Collectors.toList());

        print(newPersons);
    }

    /**
     * 逻辑统计
     */
    public void logicStat() {
        System.out.println("### logic statistic");
        Boolean isAnyInCollection = persons.stream().anyMatch(p -> p.getId() == 0);
        Boolean isAllInCollection = persons.stream().allMatch(p -> p.getAge() > 20);
        Boolean isNoneInCollection = persons.stream().noneMatch(p -> p.getId() > 50);

        print(isAnyInCollection);
        print(isAllInCollection);
        print(isNoneInCollection);
    }

    /**
     * 数值统计
     */
    public void numberStat() {
        System.out.println("### number statistic");
        IntSummaryStatistics stats = persons.stream().mapToInt(p -> p.getAge()).summaryStatistics();

        print(String.format("最大年龄: %s", stats.getMax()));
        print(String.format("最小年龄: %s", stats.getMin()));
        print(String.format("平均年龄,不可设置精度..: %s", stats.getAverage()));
        print(String.format("年龄综合: %s", stats.getSum()));
    }

    /**
     * peek is just for debugging
     */
    public void skipAndPeek() {
        System.out.println("### skip and peek");
        PersonVO p1 = persons.stream().findFirst().orElse(new PersonVO(){{setName("Jordan");}});
        print(String.format("首个元素: %s", p1));

        PersonVO p2 = persons.stream().skip(3).findFirst().get();
        print(String.format("跳开前3个后的首个元素: %s", p2));

        List<String> nameList = persons.stream().filter(p -> "Hou".equals(p.getTeam()))
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(PersonVO::getName)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());
        print(nameList);
    }


    /**
     * 分组函数
     */
    public void groupingBy() {
        System.out.println("### 分组函数");
        Map<String, List<PersonVO>> teamMap = persons.stream()
                .collect(Collectors.groupingBy(PersonVO::getTeam));
        print(teamMap);
    }

    /**
     * 分组函数 - 自定义类型
     */
    public void groupingBySpecificType() {
        System.out.println("### 分组函数（指定分组集合类型）");
        System.out.println("Set");
        Map<String, Set<PersonVO>> teamSet = persons.stream()
                .collect(Collectors.groupingBy(PersonVO::getTeam, Collectors.toSet()));
        print(teamSet);
        System.out.println("String");
        Map<String, String> teamString = persons.stream()
                .collect(Collectors.toMap(PersonVO::getTeam, PersonVO::getName, (a,b)-> a+","+b));
        print(teamString);
    }

    /**
     * 分组函数 - 求和
     */
    public void groupingBySum() {
        System.out.println("### 分组函数-求和");
        Map<String, Integer> teamString = persons.stream()
                .collect(Collectors.groupingBy(PersonVO::getTeam, Collectors.summingInt(PersonVO::getAge)));
        print(teamString);
    }

    /**
     * 分区函数
     */
    public void partitioningBy() {
        System.out.println("### 分区函数");
        Map<Boolean, List<String>> partition = Stream.of("1", "2", "3", "4", "5", "6", "7")
                .collect(Collectors.partitioningBy(t->Integer.valueOf(t)>3));
        print(partition);
    }


    private void print(Object data) {
        System.out.println(JsonUtil.toJson(data));
    }
}
