package com.asq.mysql.common;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * 以base58格式uuid字符串的主键生成器
 * 用法示例:
 * <p><pre class="code">
 *   @Id
 *   @GenericGenerator(name = "uuidGenerator", strategy = "com.asq.mysql.common.Base58UuidGenerator")
 *   @GeneratedValue(generator = "uuidGenerator")
 *   @Column("ID", length = 22)
 *   private String id;
 * </pre></p>
 * 
 * @author
 */
public class Base58UuidGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
			throws HibernateException {
		UUID uuid = UUID.randomUUID();
		ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
		bb.putLong(uuid.getMostSignificantBits());
		bb.putLong(uuid.getLeastSignificantBits());

		return Base58.encode(bb.array());
	}
}
