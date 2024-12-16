package com.du.gsfw.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.du.gsfw.model.dto.base.IPageModel;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.stream.Collectors;

public class GsUtils {
    public static String generateRandomNumber(int l) {
        String tmp = String.format("%.".concat(String.valueOf(l)).concat("f"), Math.random());
        return tmp.substring(tmp.length() - l);
    }


    public static Set<String> generatePrimaryKeySet(List lists, String keyName) {
        Set<String> set = new HashSet<>();
        for (Object obj : lists) {
            Map<String, Object> map = BeanUtil.beanToMap(obj);
            if (MapUtil.getStr(map, keyName) != null) {
                set.add(MapUtil.getStr(map, keyName));
            }
        }
        return set;
    }

    public static List copyList(List source, Class c) {

        List tList = new ArrayList<>();
        for (Object item : source) {
            try {
                Object ob = c.newInstance();
                BeanUtils.copyProperties(item, ob);
                tList.add(ob);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tList;
    }


    public static <Target, Source, Source2> List<Target> mergeCollection(List<Source> source1, List<Source2> source2, Class c) {

        List<Target> target = new ArrayList<>();
        target.addAll(GsUtils.copyList(source1, c));
        target.addAll(GsUtils.copyList(source2, c));

        return target;
    }


    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        result.add(start);
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        if (!end.equals(start)) {
            result.add(end);
        }
        return result;
    }

    public static <T> IPageModel<T> pageConvert(Page<T> page ){
        IPageModel<T> result = IPageModel.<T>builder()
                .records(page.getRecords().stream().collect(Collectors.toList()))
                .total(page.getTotal())
                .size((int) page.getSize())
                .current((int) (page.getCurrent() + 1))
                .build();
        return result;
    }
}
