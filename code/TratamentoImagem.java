package projeto_lp2;

import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

public class TratamentoImagem {
	List<Float> TratamentodaImagem(String caminho){
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			HOGDescriptor hog = new HOGDescriptor();
			Mat img = new Mat();
			MatOfFloat features = new MatOfFloat();
			img = Imgcodecs.imread(caminho, Imgcodecs.IMREAD_GRAYSCALE);
			Imgproc.resize(img, img, new Size(64,128), 0.5, 0.5, Imgproc.INTER_LINEAR);
			hog.compute(img,features);
			List<Float> arraydeFeatures = features.toList();
			return arraydeFeatures;
		}
}
