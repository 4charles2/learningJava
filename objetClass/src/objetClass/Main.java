
package objetClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Class c = String.class;
		
		Class c2 = new String().getClass();
		
		System.out.println("la class de l'objet String est " + c.getName() + " la super class de String est " + c2.getSuperclass());
		Class[] intfceStrings = c.getInterfaces();
		
		for(Class cs : intfceStrings)
			System.out.println("Les interfaces de l'objet String sont : " + cs);
		
		Method[] methClss = c.getMethods();
		System.out.println("Il y a " + methClss.length + "Méthodes dans le class :" + c.getName());
		for(Method methCls : methClss) {
			
			System.out.println("Une méthode de la class String : " + methCls);
			Class parmType[] = methCls.getParameterTypes();
			for(Class p : parmType)
				System.out.println(p.getName());
				
			System.out.println("-------------------------------------------\n");
		}
		
		Field[] decFields = c.getDeclaredFields();
		System.out.println("Il y a " + decFields.length + " champs dans cette classe !");
		for(Field decField : decFields)
			System.out.println(decField.getName());
		
		Constructor[] constStrs = c.getConstructors();
		
		System.out.println("Il y a : " + constStrs.length + " constructeur dans cette classe ! ");
		 
		for(Constructor constStr : constStrs) {
			System.out.println(constStr.getName());
			Class[] paramConsts = constStr.getParameterTypes();
			for(Class paramConst : paramConsts)
				System.out.println(paramConst);
			
			System.out.println("-------------------------------------------\n");
		}
	}

}
