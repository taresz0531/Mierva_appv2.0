package hu.tarnai.minerva.enums;

public class ErrorCodeConverter {

	public static ErrorCodeEnum getErrorCode(int res){
		if(res<-1){
			return ErrorCodeEnum.ERROR;
		}
		else if(res == -1){
			return ErrorCodeEnum.NAME_NOT_VALID_ERROR;
		}
		else{
			return ErrorCodeEnum.SUCCESS;
		}
	}
	
	public static ErrorCodeEnum getErrorCodeRoom(int res){
		if(res<-1){
			return ErrorCodeEnum.ERROR;
		}
		else if(res == -1){
			return ErrorCodeEnum.DATE_NOT_VALID;
		}
		else{
			return ErrorCodeEnum.SUCCESS;
		}
	}
}
