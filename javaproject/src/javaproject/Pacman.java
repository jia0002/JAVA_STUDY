package javaproject;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

class Pacman extends Frame implements Runnable
{	
	private Image image;
	private int sel=2;  
	private int x=225;   
	private int y=225;   
	private int MouseX;  
	private int MouseY; 
	private int [][] food;  
	private int count; 
	private Image []foodImg= new Image[5];  


	public Pacman(){
		setBounds(300,300,500,500);
		setVisible(true);
		setResizable(false);
		setTitle("체리 먹는 팩맨 게임");
			
		//먹이의 좌표 배열
		food = new int[5][2];//먹이의 x 값과 y값 좌표 저장
		for(int i=0;i<food.length;i++){
			for(int j=0;j<2;j++){
				food[i][j]=(int)(Math.random()*401)+50;   //좌표 값50~450사이의 난수 생성
			}
		}
			
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){ 
				System.exit(0); 
			}
		});
			
		this.addKeyListener(new KeyAdapter(){
			public void	keyPressed(KeyEvent e){
				if(e.getKeyCode()==e.VK_LEFT){
					sel=0;
				} else if(e.getKeyCode()==e.VK_RIGHT){
					sel=2;
				} else if(e.getKeyCode()==e.VK_UP){
					sel=4;
				} else if(e.getKeyCode()==e.VK_DOWN){
					sel=6;
				}
				repaint();
			}
		});
			
		Thread t = new Thread(this);
		t.start();
	}
	
	public void paint(Graphics g){
		Toolkit t = Toolkit.getDefaultToolkit();
		image = t.getImage("C:\\Users\\2002j\\eclipse-workspace-z\\javaproject\\src\\javaproject\\pacman.png");
		
		for(int i=0;i<5;i++){
			int x;
			int y;
			foodImg[i]=t.getImage("C:\\Users\\2002j\\eclipse-workspace-z\\javaproject\\src\\javaproject\\cherry.png");
			x=food[i][0];
			y=food[i][1];
			g.drawImage(foodImg[i], x,y,this);
		}
		g.drawImage(image, x,y,x+50,y+50,sel*50,0,sel*50+50,50,this);
	}
	
	private void restartGame() {
        count = 0;

        // 먹이의 좌표 배열 초기화
        for (int i = 0; i < food.length; i++) {
            for (int j = 0; j < 2; j++) {
                food[i][j] = (int) (Math.random() * 401) + 50;
            }
        }

        // 팩맨의 초기 위치 설정
        x = 225;
        y = 225;
        sel = 2;
        
        Thread t = new Thread(this);
        t.start();
    }
	
	
	public void run(){
		while(true){
			if(sel%2==0) 
				sel++;
			else 
				sel--;
			
			if(sel==0){
				if(x<-50){ x=520;} 
				else { x-=10; }
			} else if(sel==2){
				if(x>520){ x=-50; }  
				else { x+=10; }
			} else if(sel==4){
				if(y<-50){ y=510; } 
				else { y-=10; }
			} else if(sel==6){
				if(y>520){ y=-50; }
				else { y+=10; }
			}
			
			//팩맨 입 좌표 저장
			MouseX=x+25;
			MouseY=y+25;
			//체리를 지나가 먹을 때
			for(int i=0;i<food.length;i++){
				if(food[i][0]+20>MouseX&&food[i][0]<MouseX){   //먹이 x 값의 범주 (반경 10 이내)에 들 때
					if(food[i][1]+20>MouseY&&food[i][1]<MouseY){  //먹이 y 값의 범주 (반경 10 이내)에 들 때
						food[i][0] = (int) (Math.random() * 401) + 50; // 50~450 사이의 난수 생성
                        food[i][1] = (int) (Math.random() * 401) + 50; // 50~450 사이의 난수 생성
						count++;
					}
				}
			}
			//체리를 5번 먹었을 때 스레드 종료
			if(count==5){
				int option = JOptionPane.showOptionDialog(
                        this,
                        "게임 우승!",
                        "게임 결과",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[]{"재시작", "종료"},
                        "재시작");

                if (option == JOptionPane.YES_OPTION) {
                    // "재시작"을 선택한 경우 게임을 재시작
                    restartGame();
                    break;
                } else {
                    // "종료"를 선택한 경우 프로그램 종료
                    System.exit(0);
                }
				
			}
			repaint();
			//Exception 잡기
			try{
				Thread.sleep(80);
			} catch (InterruptedException e){ e.printStackTrace(); }
		}
	}

	public static void main(String[] args) 
	{
		Pacman paman = new Pacman();
	}
}