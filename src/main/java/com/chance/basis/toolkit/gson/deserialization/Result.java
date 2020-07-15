package com.chance.basis.toolkit.gson.deserialization;

import lombok.Data;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-07-10
 */
@Data
public class Result<T> {

    public int code;
    public String message;
    public T data;
}
