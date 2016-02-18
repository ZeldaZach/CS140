package lab04;

public class WaterJug
{
    int mili_in_jug = 0;

    public int getMilliliters()
    {
        return mili_in_jug;
    }

    public void fillUp(int ml)
    {
       mili_in_jug += ml;
    }

    public int pourOut(int ml)
    {
        // Trying to pour out too much
        if (ml > mili_in_jug)
            ml = mili_in_jug;
        
        // ML is empty, calling wrong function?
        if (ml < 0)
            ml = 0;
        
        mili_in_jug -= ml;
        
        return ml;
    }
}
