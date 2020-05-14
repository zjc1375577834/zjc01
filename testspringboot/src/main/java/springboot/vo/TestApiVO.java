package springboot.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * create by zjc in 2020/5/14 0014
 */
@Data
public class TestApiVO implements Serializable {
    private String user;
    private String passWrod;
    private String userName;
}
