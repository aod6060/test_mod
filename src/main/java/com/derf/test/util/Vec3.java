package com.derf.test.util;

public class Vec3 {
	
	
	private float x;
	private float y;
	private float z;
	
	public Vec3(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vec3()
	{
		this(0.0f, 0.0f, 0.0f);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Vec3 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	public Vec3 add(Vec3 v)
	{
		return new Vec3(x + v.x, y + v.y, z + v.z);
	}
	
	public Vec3 sub(Vec3 v)
	{
		return new Vec3(x - v.x, y - v.y, z - v.z);
	}
	
	public Vec3 mul(float f)
	{
		return new Vec3(x * f, y * f, z * f);
	}
	
	public Vec3 div(float f)
	{
		return new Vec3(x / f, y / f, z / f);
	}
	
	public float length()
	{
		return (float) Math.sqrt(x * x + y * y + z * z);
	}
	
	public Vec3 normalize()
	{
		float l = this.length();
		return new Vec3(x / l, y / l, z / l);
	}
}
