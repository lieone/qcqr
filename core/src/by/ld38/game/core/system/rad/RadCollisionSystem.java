package by.ld38.game.core.system.rad;

import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.car.Collidable;
import by.ld38.game.core.component.car.Health;
import by.ld38.game.core.component.physics.Force;
import by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core.component.rad.RadForce;
import by.ld38.game.core.component.rad.RadPosition;
import by.ld38.game.core.component.rad.RadVelocity;
import by.ld38.game.util.BoxUtil;
import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.artemis.ComponentMapper;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static by.ld38.game.util.DegreeUtil.checkCoordinate;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class RadCollisionSystem extends BaseEntitySystem {
    ComponentMapper<Health> hm;
    ComponentMapper<Position> rpm;
    ComponentMapper<RadVelocity> vm;
    ComponentMapper<RadForce> fm;

    private float collideSize = 0.2f;

    public RadCollisionSystem() {
        super(Aspect.all(Health.class, RadForce.class, RadVelocity.class, RadPosition.class, Position.class, Collidable.class));
    }

    @Override
    protected void processSystem() {
        // check all with all
        Collection<Integer> all =
                Arrays.stream(getEntityIds().getData())
                .distinct()
                .boxed()
                .collect(Collectors.toList());
        all.forEach(id -> check(id, all));
    }

    private void check(int id, Collection<Integer> all) {
        all.forEach(otherId -> check(id, otherId));
    }

    private void check(int aId, int bId) {
        if (aId == bId) return;
        Position aPos = rpm.get(aId);
        Position bPos = rpm.get(bId);

        if (    BoxUtil.checkCollision(aPos.x, aPos.y, 45f, 60f, bPos.x, bPos.y, 45, 60) &&
                Math.abs(aPos.z - bPos.z) < 5 ) collision(aId, bId);
    }

    private void collision(int aId, int bId) {
        RadVelocity aV = vm.get(aId);
        RadVelocity bV = vm.get(bId);
        Health aH = hm.get(aId);
        Health bH = hm.get(bId);

        float dmg = Math.abs(aV.alpha - bV.alpha) + Math.abs(aV.beta - bV.beta) + Math.abs(aV.gamma - bV.gamma);
        aH.value -= dmg;
        bH.value -= dmg;

        aV.alpha = -dmg;
        aV.beta = -dmg;
        //aV.gamma = -dmg;

        bV.alpha = dmg;
        bV.beta = dmg;
        //bV.gamma = dmg;

        doPop(aId);
    }

    private void doPop(int id) {
        System.out.println("COLLLLISSSION!!!");
    }
}