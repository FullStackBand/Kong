package fs.luke.kong.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fs.luke.kong.common.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据
 */
public class Page<T> {
    protected int pageNo = 1; // 当前页码
    protected int pageSize = -1; // 页面大小，设置为“-1”表示不进行分页（分页无效）

    protected long count;// 总记录数，设置为“-1”表示不查询总数

    protected int first;// 首页索引
    protected int last;// 尾页索引
    protected int prev;// 上一页索引
    protected int next;// 下一页索引
    protected int length = 8;// 显示页面长度
    protected int slider = 1;// 前后显示页面长度
    protected String funcName = "page"; // 设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。
    protected String funcParam = ""; // 函数的附加参数，第三个参数值。
    private boolean firstPage;//是否是第一页
    private boolean lastPage;//是否是最后一页
    private List<T> list = new ArrayList<T>();
    private String orderBy = ""; // 标准查询有效， 实例： updatedate desc, name asc
    private String message = ""; // 设置提示消息，显示在“共n条”之后


    public Page() {
        this.pageSize = -1;
    }

    /**
     * 构造方法
     *
     * @param request         传递 repage 参数，来记住页码
     * @param response        用于设置 Cookie，记住页码
     * @param defaultPageSize 默认分页大小，如果传递 -1 则为不分页，返回所有数据
     */
    public Page(HttpServletRequest request, HttpServletResponse response, int defaultPageSize) {
        // 1.获取页码,使用cookie记住
        String pageNo = request.getParameter("pageNo");
        if (StringUtils.isNumeric(pageNo)) {
            CookieUtils.setCookie(response, "pageNo", pageNo);
            this.pageNo = Integer.parseInt(pageNo);
        } else if (null != request.getParameter("repage")) {
            // 如果有标记 repage 就将信息记录在 cookie 中
            CookieUtils.setCookie(response, "pageNo", pageNo);
            if (StringUtils.isNumeric(pageNo)) {
                this.pageNo = Integer.parseInt(pageNo);
            }
        }

        // 2.获取页面大小,使用cookie记住
        String pageSize = request.getParameter("pageSize");
        if (StringUtils.isNumeric(pageSize)) {
            CookieUtils.setCookie(response, "pageSize", pageSize);
            this.pageSize = Integer.parseInt(pageSize);
        } else if (null != request.getParameter("repage")) {
            // 如果有标记 repage 就将信息记录在 cookie 中
            CookieUtils.setCookie(response, "pageSize", pageSize);
            if (StringUtils.isNumeric(pageSize)) {
                this.pageSize = Integer.parseInt(pageSize);
            }
        } else if (defaultPageSize > -1) {
            // 如果默认的大于 -1 则表示用户正常赋值 , 则直接写入页面大小
            this.pageSize = defaultPageSize;
        } else {
            // 其余 默认为-1 , -1表示不分页
            this.pageSize = -1;
        }

        // 3.获取排序规则
        String orderBy = request.getParameter("orderBy");
        if (StringUtils.isNumeric(orderBy)) {
            this.orderBy = orderBy;
        }

    }

    /**
     * 构造方法
     *
     * @param pageNo   当前页码
     * @param pageSize 分页大小
     */
    public Page(int pageNo, int pageSize) {
        this(pageNo, pageSize, 0);
    }

    /**
     * 构造方法
     *
     * @param pageNo   当前页码
     * @param pageSize 分页大小
     * @param count    数据条数
     */
    public Page(int pageNo, int pageSize, long count) {
        this(pageNo, pageSize, count, new ArrayList<T>());
    }

    /**
     * 构造方法
     *
     * @param pageNo   当前页码
     * @param pageSize 分页大小
     * @param count    数据条数
     * @param list     本页数据对象列表
     */
    public Page(int pageNo, int pageSize, long count, List<T> list) {
        this.setCount(count);
        this.setPageNo(pageNo);
        this.pageSize = pageSize;
        this.list = list;
    }

    /**
     * 构造方法
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置页码
     *
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取当前页码
     *
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置页面大小 (小于1时,则为10)
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        // 如果设置页面大小小于等于0 , 则默认修改为 10
        this.pageSize = pageSize <= 0 ? 10 : pageSize;
    }

    /**
     * 获取数据总数量
     *
     * @return
     */
    public long getCount() {
        return count;
    }

    /**
     * 设置数据总数量
     *
     * @param count
     */
    public void setCount(long count) {
        this.count = count;
        // 如果总数小于页面大小,则只有一页;
        if (count <= pageSize) pageNo = 1;
    }

    /**
     * 首页索引
     *
     * @return
     */
    @JsonIgnore
    public int getFirst() {
        return first;
    }

    /**
     * 尾页索引
     *
     * @return
     */
    @JsonIgnore
    public int getLast() {
        return last;
    }


    /**
     * 上一页索引值
     *
     * @return
     */
    @JsonIgnore
    public int getPrev() {
        if (isFirstPage()) {
            return pageNo;
        } else {
            return pageNo - 1;
        }
    }

    /**
     * 下一页索引
     *
     * @return
     */
    @JsonIgnore
    public int getNext() {
        if (isLastPage()) {
            return pageNo;
        } else {
            return pageNo + 1;
        }
    }


    public int getSlider() {
        return slider;
    }

    public void setSlider(int slider) {
        this.slider = slider;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncParam() {
        return funcParam;
    }

    public void setFuncParam(String funcParam) {
        this.funcParam = funcParam;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    /**
     * 获取List
     */
    public List<T> getList() {
        return this.list;
    }

    /**
     * 设置本页数据对象
     *
     * @param list
     */
    public Page<T> setList(List<T> list) {
        this.list = list;
        init();
        return this;
    }

    /**
     * 初始化参数
     */
    public void init() {

        this.first = 1;

        this.last = (int) (count / (this.pageSize < 1 ? 20 : this.pageSize) + first - 1);

        if (this.count % this.pageSize != 0 || this.last == 0) {
            this.last++;
        }

        if (this.last < this.first) {
            this.last = this.first;
        }

        if (this.pageNo <= 1) {
            this.pageNo = first;
            this.firstPage = true;
        }

        if (this.pageNo >= this.last) {
            this.pageNo = this.last;
            this.lastPage = true;
        }

        if (this.pageNo < this.last - 1) {
            this.next = this.pageNo + 1;
        } else {
            this.next = this.last;
        }

        if (this.pageNo > 1) {
            this.prev = this.pageNo - 1;
        } else {
            this.prev = this.first;
        }

        if (this.pageNo < this.first) {
            this.pageNo = this.first;
        }

        if (this.pageNo > this.last) {
            this.pageNo = this.last;
        }

    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
