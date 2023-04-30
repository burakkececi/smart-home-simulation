package abstraction;

public interface IRandomize {

    static int randomize(int min, int max){
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
