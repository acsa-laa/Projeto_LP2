package projeto_lp2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;
import java.util.List;

public class teste1 {
	public static void main(String[] args) {
		try{
			Leitura leitura = new Leitura("/home/acsa/Downloads/dataset.csv");
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
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			HOGDescriptor hog = new HOGDescriptor();
			Mat img = new Mat();
			MatOfFloat features = new MatOfFloat();
			img = Imgcodecs.imread("/home/acsa/eclipse-workspace/projeto_lp2/src/notperson.png", Imgcodecs.IMREAD_GRAYSCALE);
			Imgproc.resize(img, img, new Size(64,128), 0.5, 0.5, Imgproc.INTER_LINEAR);
			hog.compute(img,features);
			List<Float> arraydeFeatures = features.toList();
			
			Knn a = new Knn();
			System.out.println(a.KnnFunction(imagens, arraydeFeatures));
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
	
	}
}
