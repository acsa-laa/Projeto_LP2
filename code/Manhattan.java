package projeto_lp2;

import java.util.ArrayList;
import java.util.List;

public class Manhattan extends Knn {
	public String KnnFunction(int g, ArrayList<Imagem> listaImagens, List<Float> listaAtributos) {
		float [] menores = new float[g];
		Imagem [] menord = new Imagem[g];
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
			if(i < g) {
				menores[i] = soma;
				menord[i] = a;
			}
			else {
				for(int k=0; k<g; k++) {
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
		for (int i=0; i<g; i++) {
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
