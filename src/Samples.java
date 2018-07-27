import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;


public abstract class Samples {

	
	/*
	public static String genSample(){
		BufferedReader reader;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(("res/samples.txt")));
		
		int lines = 0;
		while(reader.readLine() != null) lines++;
		reader.close();
		reader = new BufferedReader(new FileReader("res/samples.txt"));
		Random rand = new Random();
		int x = rand.nextInt(lines);
		line = Files.readAllLines(Paths.get("res/samples.txt")).get(x);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
	*/
	public static String genSample(){
	String[] samples = new String[36];
	samples[0] = "152489376739256841468371295387124659591763428246895713914637582625948137873512964";
	samples[1] = "152489376739256841468371295914637582625948137873512964387124659591763428246895713";
	samples[2] = "387124659591763428246895713152489376739256841468371295914637582625948137873512964";
	samples[3] = "387124659591763428246895713914637582625948137873512964152489376739256841468371295";
	samples[4] = "914637582625948137873512964152489376739256841468371295387124659591763428246895713";
	samples[5] = "914637582625948137873512964387124659591763428246895713152489376739256841468371295";
	samples[6] = "435269781682571493197834562826195347374682915951743628519326874248957136763418259";
	samples[7] = "435269781682571493197834562519326874248957136763418259826195347374682915951743628";
	samples[8] = "826195347374682915951743628435269781682571493197834562519326874248957136763418259";
	samples[9] = "826195347374682915951743628519326874248957136763418259435269781682571493197834562";
	samples[10] = "519326874248957136763418259435269781682571493197834562826195347374682915951743628";
	samples[11] = "519326874248957136763418259826195347374682915951743628435269781682571493197834562";
	samples[12] = "123678945584239761967145328372461589691583274458792613836924157219857436745316892";
	samples[13] = "123678945584239761967145328836924157219857436745316892372461589691583274458792613";
	samples[14] = "372461589691583274458792613123678945584239761967145328836924157219857436745316892";
	samples[15] = "372461589691583274458792613836924157219857436745316892123678945584239761967145328";
	samples[16] = "836924157219857436745316892123678945584239761967145328372461589691583274458792613";
	samples[17] = "836924157219857436745316892372461589691583274458792613123678945584239761967145328";
	samples[18] = "823541769167932485549876321316297854472385196985164273298613547634758912751429638";
	samples[19] = "316297854472385196985164273823541769167932485549876321298613547634758912751429638";
	samples[20] = "823541769167932485549876321298613547634758912751429638316297854472385196985164273";
	samples[21] = "298613547634758912751429638823541769167932485549876321316297854472385196985164273";
	samples[22] = "316297854472385196985164273298613547634758912751429638823541769167932485549876321";
	samples[23] = "298613547634758912751429638316297854472385196985164273823541769167932485549876321";
	samples[24] = "265438791394175286187962534826347159519286473743591628952814367631759842478623915";
	samples[25] = "826347159519286473743591628265438791394175286187962534952814367631759842478623915";
	samples[26] = "265438791394175286187962534952814367631759842478623915826347159519286473743591628";
	samples[27] = "952814367631759842478623915265438791394175286187962534826347159519286473743591628";
	samples[28] = "826347159519286473743591628952814367631759842478623915265438791394175286187962534";
	samples[29] = "952814367631759842478623915826347159519286473743591628265438791394175286187962534";
	samples[30] = "592173864148652937673984251317598642824367195956421783469215378731849526285736419";
	samples[31] = "317598642824367195956421783592173864148652937673984251469215378731849526285736419";
	samples[32] = "592173864148652937673984251469215378731849526285736419317598642824367195956421783";
	samples[33] = "469215378731849526285736419592173864148652937673984251317598642824367195956421783";
	samples[34] = "317598642824367195956421783469215378731849526285736419592173864148652937673984251";
	samples[35] = "469215378731849526285736419317598642824367195956421783592173864148652937673984251";
	Random rand = new Random();
	int x = rand.nextInt(35);
	return samples[x];
	}
}
