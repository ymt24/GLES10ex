package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.*;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by yamato on 2016/05/27.
 */
public class NewGraphic2 implements SimpleRenderer.Obj{
    private FloatBuffer vbuf;
    private float x, y, z;

    public NewGraphic2(float s, float x, float y, float z){
        float[] vertices = {
                //face1
                0, 2*s, 0,
                s, 0, s,
                -s, 0, s,
                //face2
                0, 2*s, 0,
                -s, 0, s,
                -s, 0, -s,
                //face3
                0, 2*s, 0,
                -s, 0, -s,
                s, 0, -s,
                //face4
                0, 2*s, 0,
                s, 0, -s,
                s, 0, s,

                //face5
                0, -2*s, 0,
                s, 0, s,
                -s, 0, s,
                //face6
                0, -2*s, 0,
                -s, 0, s,
                -s, 0, -s,
                //face7
                0, -2*s, 0,
                -s, 0, -s,
                s, 0, -s,
                //face8
                0, -2*s, 0,
                s, 0, -s,
                s, 0, s,
        };
        vbuf = ByteBuffer.allocateDirect(vertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(vertices);
        vbuf.position(0);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void draw(GL10 gl){
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        gl.glNormal3f(2, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3);
        gl.glNormal3f(0, 1, 2);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 3, 3);
        gl.glNormal3f(-2, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 6, 3);
        gl.glNormal3f(0, 1, -2);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 9, 3);
        gl.glNormal3f(2, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 3);
        gl.glNormal3f(0, -1, 2);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 15, 3);
        gl.glNormal3f(-2, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 18, 3);
        gl.glNormal3f(0, -1, -2);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 21, 3);
    }

    @Override
    public float getX(){
        return x;
    }
    @Override
    public float getY(){
        return y;
    }
    @Override
    public float getZ(){
        return z;
    }
}
