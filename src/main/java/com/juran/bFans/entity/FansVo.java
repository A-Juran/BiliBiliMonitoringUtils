package com.juran.bFans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者： Juran on 2022-07-17 18:53
 * 作者博客：iit.la
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FansVo {

    private long mid;

    private long following;

    private long whisper;

    private long black;

    private long follower;

}
