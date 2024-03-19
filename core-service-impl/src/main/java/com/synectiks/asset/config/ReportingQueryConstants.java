package com.synectiks.asset.config;

/**
 * Application ReportingQueryConstants.
 */
public final class ReportingQueryConstants {

    public static String SPEND_OVERVIEW="with s as (\t\n" +
            "WITH ServiceCosts AS (\n" +
            "   SELECT\n" +
            "       ce.service_category,\n" +
            "       SUM(CAST(jb.value AS int)) AS total,\n" +
            "       null as percentage\n" +
            "   FROM\n" +
            "       cloud_element ce,\n" +
            "       landingzone l,\n" +
            "       department d,\n" +
            "       organization o,\n" +
            "        jsonb_each_text(ce.cost_json -> 'cost' -> 'DAILYCOST') AS jb(key, value)\n" +
            "   WHERE\n" +
            "       l.department_id = d.id\n" +
            "       AND d.organization_id = o.id\n" +
            "       AND ce.landingzone_id = l.id\n" +
            "       AND jb.key >= ? AND jb.key <= ? \n" +
            "       and upper(l.cloud) = upper(?)\n" +
            "       AND o.id = ? \n" +
            "       #DYNAMIC_CONDITION# \n" +
            "   GROUP BY\n" +
            "       ce.service_category\n" +
            ")\n" +
            "SELECT service_category, total, percentage FROM ServiceCosts),\n" +
            "ps as ( with psum as (select sum(total) as sumall from s)\tselect sumall from psum), \n" +
            "res as (select  s.service_category, s.total, ROUND((s.total * 100.0 / ps.sumall), 2) AS percentage from s, ps\n" +
            "union all\n" +
            "select  'Grand Total' as service_category, ps.sumall as total, null as percentage from ps)\n" +
            "select ROW_NUMBER() OVER () as id, service_category, total, percentage from res\n";

    public static String TOP_USED_SERVICES="with p as (   \n" +
            "\t  with PreviousServiceCosts as (   \n" +
            "\t  select   \n" +
            "\t   ce.element_type,   \n" +
            "\t   SUM(cast(jb.value as int)) as total   \n" +
            "\t  from   \n" +
            "\t   cloud_element ce,   \n" +
            "\t   landingzone l,   \n" +
            "\t   department d,   \n" +
            "\t   organization o,   \n" +
            "\t   jsonb_each_text(ce.cost_json -> 'cost' -> 'DAILYCOST') as jb(key,   \n" +
            "\t   value)   \n" +
            "\t  where   \n" +
            "\t   l.department_id = d.id   \n" +
            "\t   and d.organization_id = o.id   \n" +
            "\t   and ce.landingzone_id = l.id   \n" +
            "\t   and jb.key >= ?    \n" +
            "\t   and jb.key <= ?    \n" +
            "\t   and o.id = ?    \n" +
            "\t   and upper(l.cloud) = upper(?)   \n" +
            "\t    #DYNAMIC_CONDITION#    \n" +
            "\t  group by    \n" +
            "\t   ce.element_type)   \n" +
            "\t  select   \n" +
            "\t    element_type,   \n" +
            "\t   SUM(total) as total   \n" +
            "\t  from    \n" +
            "\t   PreviousServiceCosts group by element_type),    \n" +
            "  ct as ( with CurrentServiceCosts as (   \n" +
            "\t  select   \n" +
            "\t   ce.element_type,   \n" +
            "\t   SUM(cast(jb.value as int)) as total   \n" +
            "\t  from   \n" +
            "\t   cloud_element ce,   \n" +
            "\t   landingzone l,   \n" +
            "\t   department d,   \n" +
            "\t   organization o,   \n" +
            "\t   jsonb_each_text(ce.cost_json -> 'cost' -> 'DAILYCOST') as jb(key,   \n" +
            "\t   value)   \n" +
            "\t  where   \n" +
            "\t   l.department_id = d.id   \n" +
            "\t   and d.organization_id = o.id   \n" +
            "\t   and ce.landingzone_id = l.id   \n" +
            "\t   and jb.key >= ?    \n" +
            "\t   and jb.key <= ?    \n" +
            "\t   and o.id = ?    \n" +
            "\t   and upper(l.cloud) = upper(?)   \n" +
            "\t    #DYNAMIC_CONDITION#    \n" +
            "\t  group by   \n" +
            "\t   ce.element_type)   \n" +
            "\t  select   \n" +
            "\t   element_type,   \n" +
            "\t   SUM(total) as total   \n" +
            "\t  from   \n" +
            "\t   CurrentServiceCosts group by element_type),   \n" +
            "  ct_list as ( with CurrentServiceCosts as (   \n" +
            "\t  select   \n" +
            "\t   ce.element_type,   \n" +
            "\t   SUM(cast(jb.value as int)) as total   \n" +
            "\t  from   \n" +
            "\t   cloud_element ce,   \n" +
            "\t   landingzone l,   \n" +
            "\t   department d,   \n" +
            "\t   organization o,   \n" +
            "\t   jsonb_each_text(ce.cost_json -> 'cost' -> 'DAILYCOST') as jb(key,   \n" +
            "\t   value)   \n" +
            "\t  where   \n" +
            "\t   l.department_id = d.id   \n" +
            "\t   and d.organization_id = o.id   \n" +
            "\t   and ce.landingzone_id = l.id   \n" +
            "\t   and jb.key >= ?    \n" +
            "\t   and jb.key <= ?    \n" +
            "\t   and o.id = ?    \n" +
            "\t   and upper(l.cloud) = upper(?)    \n" +
            "\t    #DYNAMIC_CONDITION#    \n" +
            "\t  group by   \n" +
            "\t   ce.element_type)   \n" +
            "\t  select   \n" +
            "\t   element_type,   \n" +
            "\t   total   \n" +
            "\t  from   \n" +
            "\t   CurrentServiceCosts   \n" +
            "\t  order by total #DYNAMIC_ORDER# #DYNAMIC_LIMIT# \n" +
            "\t  ),    \n" +
            "\t  f as (select upper('Previous_Total') as element_type, sum(p.total) as total from p group by element_type   \n" +
            "\t union all   \n" +
            "\t  select upper('Current_Total') as element_type, sum(ct.total) as total from ct group by element_type    \n" +
            "\t union all    \n" +
            "\t  select upper('Percentage'), round(((ct.total-p.total)/ ct.total)* 100, 2) from ct left join p on ct.element_type = p.element_type  \n" +
            "\t union all   \n" +
            "\t  select upper(ctl.element_type), ctl.total from ct_list ctl)    \n" +
            "\t  select ROW_NUMBER() OVER () as id, element_type, sum(total) as total from f group by element_type ";

    public static String COST_OF_TOP_ACCOUNTS= "  with budget_temp as (\n" +
            "  select\n" +
            "   b.id,\n" +
            "   b.allocated_budget,\n" +
            "   b.organization_id,\n" +
            "   b.status,\n" +
            "   b.financial_year_start,\n" +
            "   b.financial_year_end , \n" +
            "   cast(bg.obj -> 'depId' as int) as dep_id,\n" +
            "   cast(bg.obj -> 'allocatedBudget' as int) as dep_allocated_budget\n" +
            "  from\n" +
            "   organization o,\n" +
            "   budget b,\n" +
            "   jsonb_array_elements(b.budget_json -> 'data') with ordinality bg(obj, pos)\n" +
            "  where\n" +
            "   o.id = b.organization_id \n" +
            "   and b.financial_year_start >= ? \n" +
            "   and b.financial_year_end <= ? \n" +
            "   and o.id = ? ),\n" +
            " ce_temp as (\n" +
            "  select\n" +
            "   o.id as organization_id,\n" +
            "   d.id as department_id,\n" +
            "   d.\"name\" as department,\n" +
            "   SUM(cast(jb.value as int)) as total\n" +
            "  from\n" +
            "   cloud_element ce, \n" +
            "      landingzone l,\n" +
            "      department d,\n" +
            "      organization o,\n" +
            "      jsonb_each_text(ce.cost_json -> 'cost' -> 'DAILYCOST') as jb(key, value)\n" +
            "  where\n" +
            "   l.department_id = d.id\n" +
            "   and d.organization_id = o.id\n" +
            "   and ce.landingzone_id = l.id\n" +
            "   and jb.key >= ? \n" +
            "   and jb.key <= ? \n" +
            "   and upper(l.cloud) = upper(?)\n" +
            "   #DYNAMIC_CONDITION# \n" +
            "   and o.id = ? \n" +
            "  group by o.id, d.id, d.\"name\"\n" +
            "  order by total desc\n" +
            ")\n" +
            " select\n" +
            "  distinct ct.department_id as id,\n" +
            "  ct.department,\n" +
            "  ct.total,\n" +
            "  bt.dep_allocated_budget,\n" +
            "  (bt.dep_allocated_budget - ct.total) as budget_consumed\n" +
            " from\n" +
            "  ce_temp ct\n" +
            " left join budget_temp bt \n" +
            "  on\n" +
            "  ct.organization_id = bt.organization_id and ct.department_id = bt.dep_id \n" +
            " order by \n" +
            "  ct.total #DYNAMIC_ORDER# #DYNAMIC_LIMIT# \n ";

    public static String SPENDING_TREND = "with p as (\n" +
            "  with PreviousServiceCosts as (\n" +
            " select\n" +
            "  'previous' as tenure,\n" +
            "  jb.key as dates,\n" +
            "  SUM(cast(jb.value as int)) as total\n" +
            " from\n" +
            "  cloud_element ce,\n" +
            "  landingzone l,\n" +
            "  department d,\n" +
            "  organization o,\n" +
            "  jsonb_each_text(ce.cost_json -> 'cost' -> 'DAILYCOST') as jb(key, value)\n" +
            " where\n" +
            "  l.department_id = d.id\n" +
            "  and d.organization_id = o.id\n" +
            "  and ce.landingzone_id = l.id\n" +
            "  and jb.key >= ?\n" +
            "  and jb.key <= ?\n" +
            "  and o.id = ?\n" +
            " group by \n" +
            "  jb.key)\n" +
            " select\n" +
            "  tenure,\n" +
            "  dates,\n" +
            "  total\n" +
            " from \n" +
            "  PreviousServiceCosts), \n" +
            " ct as ( with CurrentServiceCosts as (\n" +
            " select\n" +
            "  'current' as tenure,\n" +
            "  jb.key as dates,\n" +
            "  SUM(cast(jb.value as int)) as total\n" +
            " from\n" +
            "  cloud_element ce,\n" +
            "  landingzone l,\n" +
            "  department d,\n" +
            "  organization o,\n" +
            "  jsonb_each_text(ce.cost_json -> 'cost' -> 'DAILYCOST') as jb(key, value)\n" +
            " where\n" +
            "  l.department_id = d.id\n" +
            "  and d.organization_id = o.id\n" +
            "  and ce.landingzone_id = l.id\n" +
            "  and jb.key >= ?\n" +
            "  and jb.key <= ?\n" +
            "  and o.id = ?\n" +
            " group by\n" +
            "  jb.key)\n" +
            " select\n" +
            "  tenure,\n" +
            "  dates,\n" +
            "  total\n" +
            " from\n" +
            "  CurrentServiceCosts),\n" +
            " f as ( with FutureServiceCosts as (\n" +
            "  SELECT 'forcast' as tenure, cast(cast (generate_series(cast(? as date), cast(? as date), '1 day') as date) as text) AS dates, cast (floor(random() * 10000 + 1) as int) as total \n" +
            "  )\n" +
            " select\n" +
            "  tenure,\n" +
            "  dates,\n" +
            "  total\n" +
            " from\n" +
            "  FutureServiceCosts),\n" +
            " pmin as ( with pminimum as (select 'min' as tenure, null as dates, min(total) as total from p) select tenure, dates, total from pminimum),\n" +
            " ctmin as ( with ctminimum as (select 'min' as tenure, null as dates, min(total) as total from ct) select tenure, dates, total from ctminimum),\n" +
            " fmin as ( with fminimum as (select 'min' as tenure, null as dates, min(total) as total from f) select tenure, dates, total from fminimum),\n" +
            " allmin as (with allminimum as (\n" +
            "  select tenure, dates, total from pmin\n" +
            "  union all \n" +
            "  select tenure, dates, total from ctmin\n" +
            "  union all\n" +
            "  select tenure, dates, total from fmin\n" +
            " ) select 'min', null as dates, min(total) as total from allminimum),\n" +
            " \n" +
            " pmax as ( with pmaximum as (select 'max' as tenure, null as dates, max(total) as total from p) select tenure, dates, total from pmaximum),\n" +
            " ctmax as ( with ctmaximum as (select 'max' as tenure, null as dates, max(total) as total from ct) select tenure, dates, total from ctmaximum),\n" +
            " fmax as ( with fmaximum as (select 'max' as tenure, null as dates, max(total) as total from f) select tenure, dates, total from fmaximum),\n" +
            " allmax as (with allmaximum as (\n" +
            "  select tenure, dates, total from pmax\n" +
            "  union all \n" +
            "  select tenure, dates, total from ctmax\n" +
            "  union all\n" +
            "  select tenure, dates, total from fmax\n" +
            " ) select 'max', null as dates, max(total) as total from allmaximum),\n" +
            " res as (select 'max' as tenure, null as dates, total from allmax\n" +
            "  union all\n" +
            "  select 'min' as tenure, null as dates, total from allmin\n" +
            "  union all\n" +
            "  select  tenure, dates,  total from p \n" +
            "  union all\n" +
            "  select  tenure, dates,  total from ct \n" +
            "  union all\n" +
            "  select  tenure, dates,  total from f )\n" +
            " select ROW_NUMBER() OVER () as id, tenure, dates, total from res order by id asc";
    private ReportingQueryConstants() {
    }
}
