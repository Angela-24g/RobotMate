package com.project.robotmate.admin.domain.common.file.provider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Component
@Slf4j
@RequiredArgsConstructor
public class ThumbnailProvider {

    private final FFmpeg ffMpeg;
    private final FFprobe ffProbe;

    public File extractThumbnail(MultipartFile videoFile) throws Exception {
        File outputThumbnailFile = File.createTempFile("temp_", ".jpg");

        // MultipartFile을 임시 파일로 복사
        Path tempFilePath = outputThumbnailFile.toPath();
        Files.copy(videoFile.getInputStream(), tempFilePath, StandardCopyOption.REPLACE_EXISTING);

        File thumbnailOutputFile = File.createTempFile("thumbnail_", ".jpg"); // Create a separate output file
        thumbnailOutputFile.deleteOnExit();

        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(outputThumbnailFile.toString())
                .overrideOutputFiles(true)
                .addOutput(thumbnailOutputFile.getAbsolutePath())
                .setFrames(1) // 첫 번째 프레임을 추출하여 썸네일로 저장
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffMpeg, ffProbe);
        executor.createJob(builder).run();

        return thumbnailOutputFile;
    }

    public boolean isVideoFormat(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            byte[] signature = new byte[4];
            if (inputStream.read(signature) != 4) {
                return false;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private File convertFile(MultipartFile multipartFile) {

        try {
            File file = new File(multipartFile.getOriginalFilename());
            file.createNewFile();

            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(multipartFile.getBytes());
            outputStream.close();

            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("썸네일 생성에 실패했습니다");
    }

}
