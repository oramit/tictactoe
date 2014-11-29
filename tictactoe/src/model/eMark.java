package model;

public enum eMark 
{
	X 
	{
		@Override
		public eMark switchMark() 
		{
			return eMark.O;
		}
	},
	O 
	{
		@Override
		public eMark switchMark() 
		{
			return eMark.X;
		}
	},
	EMPTY 
	{
		@Override
		public eMark switchMark()
		{
			return eMark.EMPTY;
		}
	};
	public abstract eMark switchMark();
}
