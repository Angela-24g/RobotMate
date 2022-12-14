package cloud.aws.s3.model;

public class S3File {

    private int index;
    private String originalFileName;
    private String bucket;
    private String format;
    private Long size;

    public S3File(int index, String originalFileName, String name, String bucket, String format, Long size) {
        this.index = index;
        this.originalFileName = originalFileName;
        this.bucket = bucket;
        this.format = format;
        this.size = size;
    }

    public S3File() {
    }

    public int getIndex() {
        return index;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public String getBucket() {
        return bucket;
    }

    public String getFormat() {
        return format;
    }

    public Long getSize() {
        return size;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
