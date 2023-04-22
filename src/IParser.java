import java.io.FileNotFoundException;
import java.io.Serializable;

public interface IParser extends Serializable {
    public void parse(IModel model);

}