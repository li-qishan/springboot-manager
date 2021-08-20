package com.company.project;

import com.company.project.entity.OriginalDisk;
import com.company.project.entity.OriginalDiskIndex;
import com.company.project.mapper.OriginalDiskIndexMapper;
import com.company.project.mapper.OriginalDiskMapper;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFrameApplicationTests {

    @Autowired
    private OriginalDiskIndexMapper originalDiskIndexMapper;

    @Autowired
    private OriginalDiskMapper originalDiskMapper;


    @Test
    public void contextLoads() {
    }

    /**
     * 爬取数据
     *
     * @throws Exception
     */
    @Test
    public void CrawlIndexTest() throws Exception {
        this.CrawlIndex();
    }

    @Test
    public void CrawlDetailTest() throws Exception {
        this.CrawlDetail();
    }

    /**
     * 需手动修改
     */
    public static final String type = "4k电影原盘";


    public void CrawlIndex() {
        try {
            // 为每一页数据进行批量存储
            List<OriginalDiskIndex> data = new ArrayList<OriginalDiskIndex>();
            for (int i = 3; i <= 32; i++) {
                log.info("----------------第 {} 页 获取开始-------------", i);
                // 网页地址 https://www.bugutv.cn/4kmovie/page/3 因为要爬取分页信息，就通过循环重新加载网页来来实现，一般网页的分页URL都是有规律的，一般就是在后面的数字加1得到，所以利用这个规律来实现分页爬取数据的效果
                String url = "https://www.bugutv.cn/4kmovie/page/" + i + "";
                // 根据URL获取当前URL界面的doc对象，里面存储着界面的所有元素，类似于BOM
                log.info("----------------正在获取页面全部元素-------------");
                Document doc = Jsoup.connect(url).get();
                // 获取列表区域内容
                Element contents = doc.select("div[class=row posts-wrapper]").first();
                Thread.sleep(200);
                Elements boxContents = contents.select("div[class=col-lg-1-5 col-6 col-sm-6 col-md-4 col-lg-3]");
                Thread.sleep(200);
                // 这个就是遍历元素集合的每一个元素，来查找想要的标签对象
                log.info("----------------正在获取筛选资源数据 当前页共 {} 条可用数据-------------", boxContents.size());
                int tmp = 1;
                for (Element r : boxContents) {
                    Thread.sleep(200);
                    Elements titleData = r.select("header[class=entry-header]");
                    Thread.sleep(200);
                    Elements aData = titleData.select("h2[class=entry-title]").select("a[target=_blank]");
                    Thread.sleep(200);
                    String title = aData.attr("title");
                    String href = aData.attr("href");
                    OriginalDiskIndex odi = new OriginalDiskIndex();
                    odi.setTitle(title);
                    odi.setUrl(href);
                    odi.setPage(i);
                    odi.setType(type);
                    data.add(odi);
                    log.info("---------------当前第 {} 条正在获取--------------", tmp);
                    tmp++;
                    Thread.sleep(200);
                }
                // 准备数据存储
                System.out.println(data.size());
                log.info("----------------正在批量存储数据至云端----------------");
                data.forEach(s -> {
                    originalDiskIndexMapper.insrt(s);
                });
                log.info("------------------批量存储数据结束----------------");
                // data.forEach(System.out::println);
                log.info("----------------第 {} 页 获取结束正在清理data数据----------------", i);
                data.clear();
                // 结束一页睡眠 三秒
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CrawlDetail() {
        try {
            //从数据库中获取素有 可用片名地址准备循环爬取
            List<OriginalDiskIndex> all = originalDiskIndexMapper.all();
            all.forEach(s -> {
                try {
                    Document doc = null;
                    //originalDiskIndexMapper.insrt(s);
                    //获取详情页数据
                    String url = s.getUrl();
                    // 根据URL获取当前URL界面的doc对象，里面存储着界面的所有元素，类似于BOM
                    doc = Jsoup.connect(url).get();
                    Thread.sleep(200);
                    // 获取列表区域内容
                    String title = doc.select("h1[class=entry-title]").first().text();
                    Thread.sleep(200);
                    String contents = doc.select("article[class=article-content]").first().toString();
                    Thread.sleep(200);
                    OriginalDisk originalDisk = new OriginalDisk();
                    originalDisk.setTitle(title);
                    originalDisk.setType(type);
                    originalDisk.setContents(contents);
                    originalDiskMapper.insrt(originalDisk);
                    // 结束一页睡眠 5秒
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
