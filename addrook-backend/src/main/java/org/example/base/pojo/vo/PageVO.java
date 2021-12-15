package org.example.base.pojo.vo;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <b>分页视图信息类</b>
 * @param <E> 分页列表的泛型,继承于userVO
 * @author 王晗
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "分页视图信息",description = "分页视图信息PageVO")
public class PageVO<E extends BaseVO > implements Serializable {
	private static final long serialVersionUID = 17398085132821350L;
	@ApiModelProperty(value = "分页列表")
	protected List<E> records;                      //分页列表
	@ApiModelProperty(value = "信息总数量")
	protected long total;                           //总数量
	@ApiModelProperty(value = "每页数量")
	protected long size;                            //每页数量
	@ApiModelProperty(value = "现在页码")
	protected long current;                         //现在页码
	@ApiModelProperty(value = "排序字段信息")
	protected List<OrderItem> orders;               //排序字段信息
	@ApiModelProperty(value = "总页码")
	protected Long pages;                           //总页码
	@ApiModelProperty(value = "是否存在上一页")
	private boolean hasPrevious;                    //是否存在上一页
	@ApiModelProperty(value = "是否存在下一页")
	private boolean hasNext;                        //是否存在下一页


	public List<E> getRecords() {
		return records;
	}

	public void setRecords(List<E> records) {
		this.records = records;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getCurrent() {
		return current;
	}

	public void setCurrent(long current) {
		this.current = current;
	}

	public List<OrderItem> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderItem> orders) {
		this.orders = orders;
	}

	public Long getPages() {
		return pages;
	}

	public void setPages(Long pages) {
		this.pages = pages;
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
}
