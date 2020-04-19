package com.zemoga.portfolio.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zemoga.portfolio.model.PortfolioModel;
import com.zemoga.portfolio.persistence.PortfolioRepository;

@Repository
@Qualifier("defaultPortfolioRepositoryImpl")
public class DefaultPortfolioRepositoryImpl implements PortfolioRepository {
	private static final String SQL_FIND_BY_ID = "select * from "+PortfolioModel.TABLE_NAME+" where "+PortfolioModel.ID+" = ?";
	private static final String SQL_FILTER = "select * from "+PortfolioModel.TABLE_NAME+" where 1 = 1";
	private static final String SQL_UPDATE = "update "+PortfolioModel.TABLE_NAME+" set "
													+PortfolioModel.IMAGE_URL+" = ?, "
													+PortfolioModel.TITTLE+" = ?, "
													+PortfolioModel.TWITTER_USER_NAME+" = ?, "
													+PortfolioModel.DESCRIPTION+" = ? "
													+" where "+PortfolioModel.ID+" = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Optional<PortfolioModel> findById(Long id) {
		RowMapper<PortfolioModel> rowMapper = new PortfolioModelRowMapper();
		PortfolioModel portfolioModel = this.jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[] {id}, rowMapper);
		
        return Optional.ofNullable(portfolioModel);
	}


	@Override
	public List<PortfolioModel> filter(PortfolioModel filter) {
		StringBuffer sql = new StringBuffer(SQL_FILTER);
		
		List<String> parameterList = new ArrayList<>();
		if (!Objects.isNull(filter)) {
			if(StringUtils.isNotBlank(filter.getTwitterUserName())) {
				sql.append(" and ").append(PortfolioModel.TWITTER_USER_NAME).append(" like ?");
				parameterList.add("%"+filter.getTwitterUserName()+"%");
			}
			//TO-DO Add more filter if is necessary
		}
		
		String[] parameter = new String[parameterList.size()];
		parameterList.toArray(parameter);
		
		RowMapper<PortfolioModel> rowMapper = new PortfolioModelRowMapper();
		
		return this.jdbcTemplate.query(sql.toString(), parameter, rowMapper);
	}
	
	
	public int upate(PortfolioModel portfolioModel) {
		Object[] args = new Object[] {
								portfolioModel.getImageUrl(), portfolioModel.getTitle(), 
								portfolioModel.getTwitterUserName(), portfolioModel.getDescription(),
								portfolioModel.getId()
							};
		
		return this.jdbcTemplate.update(SQL_UPDATE, args);
	}
	
	class PortfolioModelRowMapper implements RowMapper<PortfolioModel> {
        @Override
        public PortfolioModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        	PortfolioModel portfolioModel = new PortfolioModel();
        	
        	portfolioModel.setId(rs.getLong(PortfolioModel.ID));
        	portfolioModel.setDescription(rs.getString(PortfolioModel.DESCRIPTION));
        	portfolioModel.setImageUrl(rs.getString(PortfolioModel.IMAGE_URL));
        	portfolioModel.setTitle(rs.getString(PortfolioModel.TITTLE));
        	portfolioModel.setTwitterUserName(rs.getString(PortfolioModel.TWITTER_USER_NAME));
        	
            return portfolioModel;
        }
    }
	
}
