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
@ApiModel( value = "分页视图对象",description = "分页视图信息PageVO，没有pages属性，但是在前端有pages（总页数）")
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

	/**
	 * 总页码
	 * @return Long
	 */
	public Long getPages() {
		if(this.getSize()==0L){
			//如果分页时每页数量为0,那么总页数无法计算，返回0
			return 0L;
		} else{
			Long pages=this.getTotal()/this.getSize();
			if(this.getTotal()%this.getSize()!=0L){
				//如果总页数不能整除每页数量
				++pages;
			}
			return pages;
		}
	}

	/**
	 * 是否存在上一页
	 * @return true / false
	 */
	public boolean getHasPrevious() {
		return this.current > 1;
	}

	/**
	 * 是否存在下一页
	 * @return true/false
	 */
	public boolean getHasNext() {
		return this.current < this.getPages();
	}
}
