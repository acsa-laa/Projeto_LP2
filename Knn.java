import java.util.ArrayList;
public class Knn {
	public String KnnFunction(ArrayList<Imagem> listaImagens, ArrayList<Float> listaAtributos){;
		float [] menores = new float[5];
		Imagem [] menord = new Imagem[5];
		float soma = 0;
		float aux = 0;
		int aux2 = 0;
		int contperson = 0;
		int contnotperson = 0;
		String person = listaImagens.get(0).getClasse();
		for(int i=0; i<100; i++) {
			Imagem a = listaImagens.get(i);
			ArrayList<Float> b = a.getLista();
			for(int j=0; j<999; j++) {
				if((b.get(j)-listaAtributos.get(j)) < 0) {
					soma = soma + ((b.get(j)-listaAtributos.get(j)) * -1);
				}
				else {
					soma = soma + (b.get(j)-listaAtributos.get(j));
				}
			}
			if(i < 5) {
				menores[i] = soma;
				menord[i] = a;
			}
			else {
				for(int k=0; k<5; k++) {
					if(k == 0) {
						aux = menores[k];
						aux2 = 0;
						}
					else {
						if(menores[k]>aux) {
							aux = menores[k];
							aux2 = k;
						}
					}
				}
				if(soma < aux) {
					menores[aux2] = soma;
					menord[aux2] = a;
				}
			}
			soma = 0;
		}
		for (int i=0; i<5; i++) {
			if(menord[i].getClasse().equals(person)){
				contperson = contperson + 1;
			}
			else{
				contnotperson = contnotperson + 1;
			}
		}
		if (contperson > contnotperson) {
			return "há pessoas";
		}
		else{
			return "não há pessoas";
		}
	}
}