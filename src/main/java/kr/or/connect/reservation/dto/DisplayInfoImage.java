package kr.or.connect.reservation.dto;

public class DisplayInfoImage {
	private long id;
	private long displayInfoId;
	private long fileId;
	private FileInfo fileInfo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(long displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public long getFileId() {
		return fileId;
	}
	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	public FileInfo getFileInfo() {
		return fileInfo;
	}
	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}
	
	@Override
	public String toString() {
		return "DisplayInfoImage [id=" + id + ", displayInfoId=" + displayInfoId + ", fileId=" + fileId + ", fileInfo="
				+ fileInfo + "]";
	}

}
