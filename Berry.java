public class Berry{
	private String name;
	private int restoreValue;
	private int type;

	public Berry(int type){
		this.type = type;
		switch(type){
			case 0: this.name = "Blue Berry";
				this.restoreValue = 10;
				break;
			case 1: this.name = "Red Berry";
				this.restoreValue = 20;
				break;
			case 2: this.name = "Yellow Berry";
				this.restoreValue = 50;
				break;
		}

	}

	public String getName(){
		return this.name;
	}

	public int getRestoreValue(){
		return this.restoreValue;
	}
}