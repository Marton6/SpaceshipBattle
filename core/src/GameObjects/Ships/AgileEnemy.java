package GameObjects.Ships;

import com.marton.spaceshipbattle.Level;

/**
 * Created by marton on 7/6/16.
 */
public class AgileEnemy extends EnemyShip {
    public AgileEnemy(int x, int y, int w, int h, String sprite_name, Level lvl) {
        super(x, y, w, h, 60, 5, 100, sprite_name, lvl);
    }

    private void move(float t){
        if(lvl.getObjectAt(x+dist*t+w/2, y+h/2+5, this)==null && lvl.getObjectAt(x+dist*t+w/2, y+h/2, this)==null && (x+dist<lvl.getPlayer().getX() || x+dist>lvl.getPlayer().getW()+lvl.getPlayer().getX()) && x+dist*t <= 100-w && x+dist*t >= 0 )
            x+=dist*t;
        else if(lvl.getObjectAt(x-dist*t+w/2, y+h/2+5, this)==null && lvl.getObjectAt(x-dist*t+w/2, y+h/2, this)==null && (x+dist<lvl.getPlayer().getX() || x+dist>lvl.getPlayer().getW()+lvl.getPlayer().getX()) && x+dist*t<= 100-w && x+dist*t >= 0)
            x-=dist*t;
        else{
            shoot();
            shoot();
            recalc();
        }
    }


}
