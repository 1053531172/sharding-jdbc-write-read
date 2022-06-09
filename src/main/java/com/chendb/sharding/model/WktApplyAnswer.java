package com.chendb.sharding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 答题表
 * @Author chendengbin
 * @Date 2022/6/1 14:12
 * @Version 1.0
 **/
@Data
public class WktApplyAnswer extends Model<WktApplyAnswer> implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1214090510324990108L;

    /** id,唯一键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /** 测试题目id */
    @TableField("test_question_id")
    private Long testQuestionId;

    /** 测试id */
    @TableField("test_id")
    private Long testId;

    /** 题目id */
    @TableField("question_id")
    private Long questionId;

    /** answer */
    @TableField("answer")
    private String answer;

    /** apply_answer */
    @TableField("apply_answer")
    private String applyAnswer;

    /** 答题者 */
    @TableField("apply_user_id")
    private Long applyUserId;

    /** 作答时间 */
    @TableField("apply_time")
    private Date applyTime;

    /** 结果(1对、0错) 客观题 */
    @TableField("result")
    private Integer result;

    /** 单题分数 */
    @TableField("score")
    private BigDecimal score;

    /** 批改时间 */
    @TableField("check_time")
    private Date checkTime;

    /** check_status */
    @TableField("check_status")
    private Integer checkStatus;

    /** remark */
    @TableField("remark")
    private String remark;

    /** class_id */
    @TableField("class_id")
    private Long classId;

    /** group_id */
    @TableField("group_id")
    private Long groupId;

    /** 是否优秀答案标记(0: 不是优秀答案; 1: 是优秀答案) */
    @TableField("good_answer")
    private Integer goodAnswer;

    /** 是否优秀答案标记时间 */
    @TableField("good_answer_time")
    private Date goodAnswerTime;

    /** 音频评语地址 */
    @TableField("audio_remark_url")
    private String audioRemarkUrl;

    /** 音频评语时长 */
    @TableField("audio_remark_time")
    private BigDecimal audioRemarkTime;

    /** 点阵笔背景图片url */
    @TableField("backgroup_url")
    private String backgroupUrl;

    /** 点阵笔背景图片类型，1标准答题卡，2非标准答题卡 */
    @TableField("backgroup_type")
    private Integer backgroupType;

    /** 课程id,对应wkt_course的主键id */
    @TableField("course_Id")
    private Long courseId;

    /** 总用时(毫秒) */
    @TableField("total_time")
    private Long totalTime;
}
