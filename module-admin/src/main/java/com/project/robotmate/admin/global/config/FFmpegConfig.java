package com.project.robotmate.admin.global.config;

import lombok.extern.slf4j.Slf4j;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Slf4j
@Configuration
public class FFmpegConfig {

    @Value("${ffmpeg.main.location}")
    public String ffmpegLocation;

    @Value("${ffmpeg.probe.location}")
    private String ffprobeLocation;

    @Bean
    public FFmpeg ffMpeg() throws IOException {
        FFmpeg ffMPeg = null;

        String osName = System.getProperty("os.name");

        // 운영체제가 Window인 경우 jar에 내장되어있는 ffmpeg 를 이용
        if (osName.toLowerCase().contains("win")) {
            ClassPathResource classPathResource = new ClassPathResource(ffmpegLocation);
            log.info("classPathResource : {}", classPathResource);
            ffMPeg = new FFmpeg(classPathResource.getURL().getPath());
//            ffMPeg = new FFmpeg("classpath:static/ffmpeg.exe");
        } else if(osName.toLowerCase().contains("unix") || osName.toLowerCase().contains("linux")) {
            ffMPeg = new FFmpeg(ffmpegLocation);
        }

        return ffMPeg;
    }

    @Bean
    public FFprobe ffProbe() throws IOException {
        FFprobe ffprobe = null;

        String osName = System.getProperty("os.name");

        // 운영체제가 Window인 경우 jar에 내장되어있는 ffmpeg 를 이용
        if (osName.toLowerCase().contains("win")) {
            ClassPathResource classPathResource = new ClassPathResource(ffprobeLocation);
            log.info("classPathResource : {}", classPathResource);
            ffprobe = new FFprobe(classPathResource.getURL().getPath());
//            ffprobe = new FFprobe("classpath:static/ffprobe.exe");
        } else if(osName.toLowerCase().contains("unix") || osName.toLowerCase().contains("linux")) {
            ffprobe = new FFprobe(ffmpegLocation);
        }

        return ffprobe;
    }
}
