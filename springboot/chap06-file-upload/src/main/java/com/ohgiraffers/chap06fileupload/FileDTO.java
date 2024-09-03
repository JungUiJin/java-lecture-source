package com.ohgiraffers.chap06fileupload;

// 업로드된 파일과 관련한 정보를 모아서 관리하는 DTO 클래스
public class FileDTO {
    private String originalFilename;
    private String saveFilename;
    private String filePath;
    private String fileDescription;
    public FileDTO(String originalFilename, String saveFilename, String filePath, String fileDescription) {
        this.originalFilename = originalFilename;
        this.saveFilename = saveFilename;
        this.filePath = filePath;
        this.fileDescription = fileDescription;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "originalFilename='" + originalFilename + '\'' +
                ", saveFilename='" + saveFilename + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                '}';
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getSaveFilename() {
        return saveFilename;
    }

    public void setSaveFilename(String saveFilename) {
        this.saveFilename = saveFilename;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
