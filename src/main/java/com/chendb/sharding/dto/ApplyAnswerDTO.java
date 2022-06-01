package com.chendb.sharding.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @Author chendengbin
 * @Date 2022/6/1 14:41
 * @Version 1.0
 **/
@Data
public class ApplyAnswerDTO implements Serializable {
    /** id,唯一键 */
    private Long id;

    /** 测试题目id */
    private Long testQuestion;

    /** 测试id */
    private Long testId;

    /** 题目id */
    private Long questionId;

    /** answer */
    private String answer;

    /** apply_answer */
    private String applyAnswer;

    /** 答题者 */
    private Long applyUserId;

    /** 作答时间 */
    private Date applyTime;

    /** 结果(1对、0错) 客观题 */
    private Integer result;

    /** 单题分数 */
    private BigDecimal score;

    /** 批改时间 */
    private Date checkTime;

    /** check_status */
    private Integer checkStatus;

    /** remark */
    private String remark;

    /** class_id */
    private Long classId;

    /** group_id */
    private Long groupId;

    /** 是否优秀答案标记(0: 不是优秀答案; 1: 是优秀答案) */
    private Integer goodAnswer;

    /** 是否优秀答案标记时间 */
    private Date goodAnswerTime;

    /** 音频评语地址 */
    private String audioRemarkUrl;

    /** 音频评语时长 */
    private BigDecimal audioRemarkTime;

    /** 点阵笔背景图片url */
    private String backgroupUrl;

    /** 点阵笔背景图片类型，1标准答题卡，2非标准答题卡 */
    private Integer backgroupType;

    /** 课程id,对应wkt_course的主键id */
    private Long courseId;

    /** 总用时(毫秒) */
    private Long totalTime;
}
