package com.catt.service1.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 割接前后告警采集日志Entity
 *
 * @author 黄智杰
 * @Date 2020-06-16
 */
@ApiModel(description = "割接前后日志采集日志表Entity")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_cutover_alarm_sync_log")
public class TCutoverAlarmSyncLog extends Model<TCutoverAlarmSyncLog> {

    public static final String ID = "id";
    public static final String CUTOVER_ID = "cutover_id";
    public static final String OPERATE_TYPE = "operate_type";
    public static final String STATUS = "status";
    public static final String CREATE_TIME = "create_time";
    public static final String UPDATE_TIME = "update_time";
    public static final String UPDATE_USER = "update_user";
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    @ApiModelProperty(value = "割接事件id")
    @TableField("cutover_id")
    private Long cutoverId;
    @ApiModelProperty(value = "操作类型	1 割接前采集            2 割接后采集            3 手动采集")
    @TableField("operate_type")
    private Integer operateType;
    @ApiModelProperty(value = "本次告警采集状态	1 正常采集数据为空            2 正常采集数据且有数据            3 采集异常")
    @TableField("status")
    private Integer status;
    @ApiModelProperty(value = "插入时间")
    @TableField("create_time")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;
    @ApiModelProperty(value = "更新人")
    @TableField("update_user")
    private String updateUser;
}