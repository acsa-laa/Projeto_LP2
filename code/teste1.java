package projeto_lp2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class teste1 {
	public static void main(String[] args) {
		try{
			Leitura leitura = new Leitura("/home/acsa/Downloads/dataset_2019_1.csv");
			ArrayList<Imagem> imagens = new ArrayList<Imagem>();
			//System.out.println(leitura.lerLinhas());
			while(leitura.lerLinhas() != 1) {
				Imagem imagem = new Imagem(leitura.getLista(), leitura.getClasse());
				imagens.add(imagem);
			}
			
			TratamentoImagem d = new TratamentoImagem();
			Knn a = new Euclidiana();
			Knn b = new Manhattan();
			Knn c = new Chebychev();
			List<Float> arraydeFeatures = d.TratamentodaImagem("/home/acsa/Documentos/LP2/Projeto-LP2/person/positive-000200.png");
			System.out.println(a.KnnFunction(3,imagens, arraydeFeatures));
			System.out.println(b.KnnFunction(3,imagens, arraydeFeatures));
			System.out.println(c.KnnFunction(3,imagens, arraydeFeatures));
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
	
	}
}
