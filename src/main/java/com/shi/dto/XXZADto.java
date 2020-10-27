package com.shi.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author DaTou
 * @Description 学习铸安
 * @Date 2020/10/3
 **/
@Data
public class XXZADto implements Serializable {

    private String code;

    private String errMsg;

    private QuesList data;
}
@Data
class QuesList implements Serializable{
    List<A> quesList;
}

@Data
class A implements Serializable{
    private List<Opts> opts;

    private int diffType;

    private int id;

    private String parsing;

    private String content;

    private String quesType;
}
@Data
class Opts implements Serializable{
    private int isRightAnswer;

    private int optIndex;

    private int id;

    private int quesId;

    private String content;
}