package com.demo.sharding.data;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @Author RuanShaoKang
 * @since 2021/8/24 17:00
 */
@Data
@Accessors(chain = true)
@TableName(value = "student_info", autoResultMap = true)
public class StudentInfoDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String className;
    private Long classId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
