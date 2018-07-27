import java.awt.Color;
import java.util.Random;


public class Board {

	private Fields[][] fArr;
	public Fields[][] fTd; 
	
	public Board(){
		
	}
	
	public String genStr(){
		return Samples.genSample();
	}
	
	public boolean checkBoard(){
		boolean isWrong = false;
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(fTd[i][j].getVal() != 0){
					for(int k = j+1; k < 9; k++){
						if(fTd[i][j].getVal() == fTd[i][k].getVal())
							isWrong = true;
					}
					for(int k = i+1; k < 9; k++){
						if(fTd[i][j].getVal() == fTd[k][j].getVal())
							isWrong = true;
					}
					for(int x = 0; x < 3; x++){
						for(int y = 0; y < 3; y++){
							for(int k = x*3; (k+1)%3 == 0; k++){
								for(int l = y*3+1; (l+1)%3 == 0; l++){
									if(fTd[k][l].getVal() == fTd[i][j].getVal())
										isWrong = true;
								} // for l
							} // for k
						} // for y
					} // for x
				} // if !=0		 	
			} // for j
		} // for i
				return isWrong;
	}
	
	public void fillBoard(int lv){
		String str = this.genStr();
		if(str.length() != 81){
			System.out.println("WRONG STRING LENGTH");
			return;
		} else {
			fArr = new Fields[9][9];
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					System.out.println("i "+i+" j "+j);
					fArr[i][j] = new Fields();
					fArr[i][j].setVal(Character.getNumericValue(str.charAt(0)));
					
					str = str.substring(1);
				}
			}
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					System.out.printf("%s ", fArr[i][j].getVal());
				}
				System.out.println();
			}
			
				switch(lv){
				case 1:
					lvEasy();
					break;
				case 2:
					lvMed();
					break;
				case 3:
					lvHard();
					break;
				}
			
		}
	}
	
	private void erase(int qty){
		fTd = new Fields[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++){
				fTd[i][j] = new Fields();
				fTd[i][j].setVal(fArr[i][j].getVal());
			}
		
		
		
		
		for(int x = 0; x < qty; x++){
			int ite = 0;
			Random rand = new Random();
			int r = rand.nextInt(81);
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					if(ite != r)
						ite++;
					else{
						fTd[i][j].setVal(0);
						fTd[i][j].setEditable(true);
						fTd[i][j].setColor(Color.RED);
						ite++;
					}
						
				}
			}
		}
		
	}
	
	private void lvEasy(){
		this.erase(30);
	}
	
	private void lvMed(){
		this.erase(50);
	}
	
	private void lvHard(){
		this.erase(70);
	}

	public boolean isFilled() {
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(fTd[i][j].getVal() == 0)
					return false;
			}
		}
		return true;
	}

	public void solve() {
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				fTd[i][j].setVal(fArr[i][j].getVal());
			}
		}
	}
		
	
}
