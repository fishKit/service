package com.catt.service1.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_cutover_rel_alarm")
public class TCutoverRelAlarm extends Model<TCutoverRelAlarm> {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "I_ID", type = IdType.INPUT)
    private Long id;
    @ApiModelProperty(value = "割接事件ID")
    @TableField("I_CUTOVER_ID")
    private Long cutoverId;
    @ApiModelProperty(value = "告警ID")
    @TableField("I_ALARM_ID")
    private Long alarmId;
    @ApiModelProperty(value = "告警对象友好名称")
    @TableField("S_OBJECT_FRIEND_NAME")
    private String objectFriendName;
    @ApiModelProperty(value = "告警原因")
    @TableField("S_PROB_CAUSE")
    private String probCause;
    @ApiModelProperty(value = "告警类型 1：设备告警 2：板卡告警 3：电路告警 4：端口告警 5：系统告警 7：光缆监控告警 8：保护倒换告警 9：光开关切换告警 10：光开关告警 12：业务告警 17：派生电路告警 18：DDOS攻击 19：光路告警")
    @TableField("I_ALARM_TYPE")
    private Integer alarmType;
    @ApiModelProperty(value = "告警系统时间")
    @TableField("D_SYSTEM_TIME")
    private Date systemTime;
    @ApiModelProperty(value = "告警级别 1：紧急 2：主要 3：一般 4：提示 5：未知 6：事件 101：A 102：B  103：C++ 104:C+ 105:C 106:C- 107：D 108:D- 109:N 110:Unk 111:预警故障")
    @TableField("I_ALARM_LEVEL")
    private Integer alarmLevel;
    @ApiModelProperty(value = "事件与告警关联标示 1：割接前告警  2：割接后告警")
    @TableField("I_REL_FLAG")
    private Integer relFlag;
    @ApiModelProperty(value = "清除时间")
    @TableField("D_SYSTEM_CLEAR_TIME")
    private Date systemClearTime;
    @ApiModelProperty(value = "割接关联告警表新增入库时间字段")
    @TableField("D_INSERT_TIME")
    private Date insertTime;
    @ApiModelProperty(value = "对象ID")
    @TableField("S_OBJECT_ID")
    private String objectId;
    @ApiModelProperty(value = "对象类型【参考告警表枚举】")
    @TableField("I_OBJECT_TYPE")
    private Integer objectType;
    @ApiModelProperty(value = "插板id")
    @TableField("S_BOARD_ID")
    private String boardId;
    @ApiModelProperty(value = "告警对象类型【参考告警表枚举】")
    @TableField("I_ALARM_OBJ_TYPE")
    private Integer alarmObjType;
    @ApiModelProperty(value = "标准告警名称")
    @TableField("S_CT_ALARM_CAUSE")
    private String ctAlarmCause;

    @ApiModelProperty(value = "告警存在标识 2 消除 3 新增 4 不变")
    @TableField("I_ALARM_IDENTIFICAT")
    private Integer alarmIdentificat;
}