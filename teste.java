package projeto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Leitura leitura = new Leitura("C:\\Users\\marti\\Downloads\\dataset.csv");
			ArrayList<Imagem> imagens = new ArrayList<Imagem>();
			//System.out.println(leitura.lerLinhas());
			while(leitura.lerLinhas() != 1) {
				Imagem imagem = new Imagem(leitura.getLista(), leitura.getClasse());
				imagens.add(imagem);
			}
			for(Imagem i : imagens) {
				for(Float f : i.getLista()) {
					System.out.print(f + ",");
				}
				System.out.println(i.getClasse());
				System.out.println();
			}
			Knn a = new Knn();
			System.out.println(a.KnnFunction(imagens, imagens.get(20).getLista));
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
	} 
}
