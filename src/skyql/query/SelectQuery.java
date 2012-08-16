package skyql.query;



import java.util.List;


import com.zealjagannatha.parsebuilder.BuildableClass.Buildable;
import com.zealjagannatha.parsebuilder.TokenField.Token;


@Buildable(prefix="select")
public class SelectQuery extends Query {
	
	@Token(position=0,subtype=ColumnName.class)
	private List<ColumnName> columnList;
	
	@Token(position=1,prefix="from")
	private TableName tableName;
	
	@Token(position=2,optional=true,prefix="where")
	private Expression expression;
	
	@Token(position=3,optional=true,prefix={"order","by"},subtype=Ordering.class)
	private List<Ordering> orderings;
	
	public SelectQuery(List<ColumnName> columns, TableName tableName, Expression expression, List<Ordering> orderings) {
		if(columns == null)
			throw new IllegalStateException("Column list cannot be null.");
		if(tableName == null)
			throw new IllegalStateException("Table name cannot be null.");
		this.tableName = tableName;
		this.columnList = columns;
		this.expression = expression;
		this.orderings = orderings;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("SELECT %s FROM '%s'",columnList.toString(),tableName));
		if(expression != null)
			result.append(" WHERE "+expression.toString());
		if(orderings != null)
			result.append(" ORDER BY "+orderings.toString());
		return result.toString();
	}

}
