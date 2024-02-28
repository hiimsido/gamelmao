package ShadowsRPG.maps;

import java.util.ArrayList;

public class Coordinates {
   public int X;
   public int Y;

    public Coordinates(int X, int Y)
    {
        this.X = X;
        this.Y = Y;
    }

    Coordinates()
    {

    }


    public void setCoord(int X, int Y)
    {
        X = X;
        Y = Y;
    }

    public String getCoord()
    {
        return (X + "," + Y);
    }

    public int[] getCoordInt()
    {
        return new int[] {X,Y};
    }

   public boolean coordCheck (String c, ArrayList<Coordinates> b)
    {
        for (Coordinates each: b
             ) {

            boolean truth = (c.equals(each.getCoord()));
            if (truth) {
                return true;
            }
        }
        return false;
    }

    public boolean coordCheckB (int[] a, ArrayList<int[]> b)
    {
        for (int[] each: b
        ) {

            boolean truth = (a[0]==each[0]&&a[1]==each[1]);
            if (truth) {
                return true;
            }
        }
        return false;
    }



    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(X).append(",");
        sb.append(Y);
        return sb.toString();
    }



}
