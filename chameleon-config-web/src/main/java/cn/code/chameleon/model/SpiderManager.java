package cn.code.chameleon.model;

import cn.code.chameleon.Spider;
import cn.code.chameleon.spider.CommonSpider;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liumingyu
 * @create 2018-05-15 下午2:11
 */
@Component
public class SpiderManager {

    private Map<String, CommonSpider> commonSpiderMap = new ConcurrentHashMap<>();

    public void put(String key, CommonSpider value) {
        commonSpiderMap.put(key, value);
    }

    public CommonSpider getSpiderById(String key) {
        return commonSpiderMap.get(key);
    }

    public Map<String, CommonSpider> get() {
        return commonSpiderMap;
    }

    public List<CommonSpider> all() {
        List<CommonSpider> commonSpiders = Lists.newArrayListWithCapacity(commonSpiderMap.size());
        for (CommonSpider commonSpider : commonSpiderMap.values()) {
            commonSpiders.add(commonSpider);
        }
        return commonSpiders;
    }

    public List<CommonSpider> getRunningSpider() {
        List<CommonSpider> commonSpiders = new ArrayList<>();
        for (CommonSpider commonSpider : commonSpiderMap.values()) {
            if (commonSpider.getStatus().equals(Spider.Status.Running)) {
                commonSpiders.add(commonSpider);
            }
        }
        return commonSpiders;
    }

    public void remove(String key) {
        commonSpiderMap.remove(key);
    }

    public void removeAll() {
        commonSpiderMap.clear();
    }
}
