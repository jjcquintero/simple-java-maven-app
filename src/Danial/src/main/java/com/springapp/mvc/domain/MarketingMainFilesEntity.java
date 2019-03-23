package com.springapp.mvc.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by bruntha on 10/31/15.
 */
@Entity
@Table(name = "marketing_main_files", schema = "", catalog = "danial")
public class MarketingMainFilesEntity {
    private int fileId;
    private String fileName;
    private Timestamp uploadedTime;
    private byte processingStatus;
    private String uploadedBy;

    @Id
    @Column(name = "fileID")
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "fileName")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "uploadedTime")
    public Timestamp getUploadedTime() {
        return uploadedTime;
    }

    public void setUploadedTime(Timestamp uploadedTime) {
        this.uploadedTime = uploadedTime;
    }

    @Basic
    @Column(name = "processingStatus")
    public byte getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(byte processingStatus) {
        this.processingStatus = processingStatus;
    }

    @Basic
    @Column(name = "uploadedBy")
    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketingMainFilesEntity that = (MarketingMainFilesEntity) o;

        if (fileId != that.fileId) return false;
        if (processingStatus != that.processingStatus) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (uploadedBy != null ? !uploadedBy.equals(that.uploadedBy) : that.uploadedBy != null) return false;
        if (uploadedTime != null ? !uploadedTime.equals(that.uploadedTime) : that.uploadedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fileId;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (uploadedTime != null ? uploadedTime.hashCode() : 0);
        result = 31 * result + (int) processingStatus;
        result = 31 * result + (uploadedBy != null ? uploadedBy.hashCode() : 0);
        return result;
    }
}
