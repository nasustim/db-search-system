import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ConvertString {
	StringBuffer s1;
	public String ConvertInString(String ms){
	
		System.out.println(ms);
		
		
		ms = ms.replace("\\<","\\\\\\\\<");
		
	
		//s1 = new StringBuffer(ms);
		ms = Pattern.compile("∈").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<in>");
		ms = Pattern.compile("¯").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<inverse>");
		ms = Pattern.compile("ı").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<index>");
		ms = Pattern.compile("ℤ").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<int>");
		ms = Pattern.compile("∞").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<infinity>");
		ms = Pattern.compile("→").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<rightarrow>");
		ms = Pattern.compile("⋀").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<And>");
		ms = Pattern.compile("⋁").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<Or>");
		ms = Pattern.compile("≠").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<noteq>");
		ms = Pattern.compile("⊂").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<subset>");
		ms = Pattern.compile("⊆").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<subseteq>");
		ms = Pattern.compile("∪").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<union>");
		ms = Pattern.compile("¬").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<not>");
		ms = Pattern.compile("∩").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<inter>");
		ms = Pattern.compile("≤").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<le>");
		ms = Pattern.compile("×").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<times>");
		ms = Pattern.compile("⋅").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<cdot>");
		ms = Pattern.compile("λ").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<lambda>");
		ms = Pattern.compile("∨").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<or>");
		ms = Pattern.compile("∧").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<and>");
		ms = Pattern.compile("⨁").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<Oplus>");
		ms = Pattern.compile("▹").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<triangleright>");
		ms = Pattern.compile("⨀").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<Odot>");
		ms = Pattern.compile("⋆").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<star>");
		ms = Pattern.compile("Σ").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<Sigma>");
		ms = Pattern.compile("⋂").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<Inter>");
		ms = Pattern.compile("≅").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<cong>");
		ms = Pattern.compile("⋃").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<Union>");
		ms = Pattern.compile("⦇").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<lparr>");
		ms = Pattern.compile("⦈").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<rparr>");
		ms = Pattern.compile("ι").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<iota>");
		ms = Pattern.compile("Π").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<Pi>");
		ms = Pattern.compile("⊎").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<uplus>");
		ms = Pattern.compile("⊙").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<odot>");
		ms = Pattern.compile("⊲").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<lhd>");
		ms = Pattern.compile("♢").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<diamondsuit>");
		ms = Pattern.compile("‡").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<ddagger>");
		ms = Pattern.compile("⇧").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<^sup>");
		ms = Pattern.compile("♭").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<flat>");
		ms = Pattern.compile("⇘").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<^bsub>");
		ms = Pattern.compile("⇙").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<^esub>");
		ms = Pattern.compile("­").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<hyphen>");//心配
		ms = Pattern.compile("⇖").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<^esup>");
		ms = Pattern.compile("⇗").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<^bsup>");
		ms = Pattern.compile("†").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<dagger>");
		ms = Pattern.compile("°").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<degree>");
		ms = Pattern.compile("∘").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<circ>");
		ms = Pattern.compile("¨").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<dieresis>");
		ms = Pattern.compile("¦").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<bar>");
		ms = Pattern.compile("∷").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<Colon>");
		ms = Pattern.compile("⟧").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<rbrakk>");
		ms = Pattern.compile("⟦").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<lbrakk>");
		ms = Pattern.compile("∀").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<forall>");
		ms = Pattern.compile("∃").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<exists>");
		ms = ms.replace("⟹","\\\\\\\\<Longrightarrow>");
		ms = ms.replace("⟶","\\\\\\\\<longrightarrow>");
		ms = ms.replace("⟷","\\\\\\\\<longleftrightarrow>");
		ms = ms.replace("⟺","\\\\\\\\<Longleftrightarrow>");
//		ms = Pattern.compile(/*"⟹"*/"\ue29fb9").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<Longrightarrow>");
//		ms = Pattern.compile(/*"⟶"*/"\ue29fb6").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<longrightarrow>");
		ms = Pattern.compile("⇩").matcher(ms).replaceAll("\\\\\\\\\\\\\\\\<^sub>");


		/*\<^sync>が記号に変換できなかった　　　57*/
		System.out.println(ms);
		
		/*
		ms = ms.replaceAll("∀","\\$\\\\forall\\$");
		ms = ms.replaceAll("∃","\\$\\\\exists\\$");
		ms = ms.replaceAll("⇒","\\$\\\\Longrightarrow\\$");
		ms = ms.replaceAll("→","\\$\\\\longrightarrow\\$");
		ms = ms.replaceAll("⇩2","\\$_{2}\\$");
		ms = ms.replaceAll("⇩3","\\$_{3}\\$");*/
		/*int a = -1;
		a = ms.indexOf("∀");
		if(a != -1){
			s1.replace(a,a+1,"$\\forall$");
			a = -1;
		}
		a = ms.indexOf("∃");
		if(a != -1){
			s1.replace(a,a+1,"$\\exists$");
			a = -1;
		}
		a = ms.indexOf("⇒");
		if(a != -1){
			s1.replace(a,a+1,"$\\Longrightarrow$");
			a = -1;
		}
		a = ms.indexOf("→");
		if(a != -1){
			s1.replace(a,a+1,"$\\longrightarrow$");
			a = -1;
		}
		a = ms.indexOf("⇩2");
		if(a != -1){
			s1.replace(a,a+2,"$_{2}$");
			a = -1;
		}
		a = ms.indexOf("⇩3");
		if(a != -1){
			s1.replace(a,a+2,"$_{3}$");
			a = -1;
		}*/
		return ms;
	}
	
	public String xsymToSym(String ms){
		ms = ms.replace("\\<in>","∈");
		ms = ms.replace("\\<inverse>","¯");
		ms = ms.replace("\\<index>","ı");
		ms = ms.replace("\\<int>","ℤ");
		ms = ms.replace("\\<infinity>","∞");
		ms = ms.replace("\\<rightarrow>","→");
		ms = ms.replace("\\<And>","⋀");
		ms = ms.replace("\\<Or>","⋁");
		ms = ms.replace("\\<noteq>","≠");
		ms = ms.replace("\\<subset>","⊂");
		ms = ms.replace("\\<subseteq>","⊆");
		ms = ms.replace("\\<union>","∪");
		ms = ms.replace("\\<not>","¬");
		ms = ms.replace("\\<inter>","∩");
		ms = ms.replace("\\<le>","≤");
		ms = ms.replace("\\<times>","×");
		ms = ms.replace("\\<cdot>","⋅");
		ms = ms.replace("\\<lambda>","λ");
		ms = ms.replace("\\<or>","∨");
		ms = ms.replace("\\<and>","∧");
		ms = ms.replace("\\<Oplus>","⨁");
		ms = ms.replace("\\<triangleright>","▹");
		ms = ms.replace("\\<Odot>","⨀");
		ms = ms.replace("\\<star>","⋆");
		ms = ms.replace("\\<Sigma>","Σ");
		ms = ms.replace("\\<Inter>","⋂");
		ms = ms.replace("\\<cong>","≅");
		ms = ms.replace("\\<Union>","⋃");
		ms = ms.replace("\\<lparr>","⦇");
		ms = ms.replace("\\<rparr>","⦈");
		ms = ms.replace("\\<iota>","ι");
		ms = ms.replace("\\<Pi>","Π");
		ms = ms.replace("\\<uplus>","⊎");
		ms = ms.replace("\\<odot>","⊙");
		ms = ms.replace("\\<lhd>","⊲");
		ms = ms.replace("\\<diamondsuit>","♢");
		ms = ms.replace("\\<ddagger>","‡");
		ms = ms.replace("\\<^sup>","⇧");
		ms = ms.replace("\\<flat>","♭");
		ms = ms.replace("\\<^bsub>","⇘");
		ms = ms.replace("\\<^esub>","⇙");
		ms = ms.replace("\\<hyphen>","­");
		ms = ms.replace("\\<^esup>","⇖");
		ms = ms.replace("\\<^bsup>","⇗");
		ms = ms.replace("\\<dagger>","†");
		ms = ms.replace("\\<degree>","°");
		ms = ms.replace("\\<circ>","∘");
		ms = ms.replace("\\<dieresis>","¨");
		ms = ms.replace("\\<bar>","¦");
		ms = ms.replace("\\<Colon>","∷");
		ms = ms.replace("\\<rbrakk>","⟧");
		ms = ms.replace("\\<lbrakk>","⟦");
		ms = ms.replace("\\<forall>","∀");
		ms = ms.replace("\\<exists>","∃");
		ms = ms.replace("\\<Longrightarrow>","⟹");
		ms = ms.replace("\\<longrightarrow>","⟶");
		ms = ms.replace("\\<longleftrightarrow>","⟷");
		ms = ms.replace("\\<Longleftrightarrow>","⟺");
		ms = ms.replace("\\<^sub>","⇩");
		
		return ms;
	}
	
}