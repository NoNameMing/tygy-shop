-- 0. 获取该类别的所有信息 (findById方法，已经存在)
select id, category_description, category_name, category_parentId, leaf, grade from t_category where id=#{id}

-- 1. 判断该类别有没有子类别，找儿子的过程
select count(id) from t_category where category_parentId=#{id}

-- 2. 判断该类别下有无商品
select count(id) from t_product where product_categoryid=#{id}

-- 3. 判断该类别的父类别是否需要更新，找父亲的过程
select count(id) from t_category where category_parentId=#{pid}

-- 4. 需要更新的话，更新该商品的父类别的 叶子结点 字段
update t_category set leaf=1 where id=#{pid}


-- 根据子类别找父类别
