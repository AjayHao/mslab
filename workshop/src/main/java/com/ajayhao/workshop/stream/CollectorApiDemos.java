package com.ajayhao.workshop.stream;

import com.ajayhao.mslab.core.util.JsonUtil;
import com.ajayhao.workshop.PersonVO;
import com.fasterxml.jackson.core.type.TypeReference;
import jodd.io.FileUtil;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

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
        demo.filterWithSort();
        demo.logicStat();
        demo.numberStat();
        demo.peek();
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
     * peek
     */
    public void peek() {
        System.out.println("### number statistic");
        PersonVO p1 = persons.stream().findFirst().orElse(new PersonVO(){{setName("Jordan");}});
        print(String.format("首个元素: %s", p1));

        PersonVO p2 = persons.stream().skip(3).findFirst().get();
        print(String.format("首个元素: %s", p2));

        List<String> nameList = persons.stream().filter(p -> "Hou".equals(p.getTeam()))
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(PersonVO::getName)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());
        print(nameList);
    }

    private void print(Object data) {
        System.out.println(JsonUtil.toJson(data));
    }
}
