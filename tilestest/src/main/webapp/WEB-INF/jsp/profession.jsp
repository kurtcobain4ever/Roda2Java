<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="datetag" uri="/tags" %>
<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
        <a class="nav-bar-a" href="">前端开发</a>
        <a class="nav-bar-a" href="">后端开发</a>
        <a class="nav-bar-a" href="">移动开发</a>
        <a class="nav-bar-a" href="">整站开发</a>
        <a class="nav-bar-a" href="">运营维护</a>
    </div>


    <div class="caption">
        <h4>前端开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${professions}" var="item" varStatus="true">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix" style="display: flex">
                        <div class="icon-people"><img src="${pageContext.request.contextPath}${item.img}"></div>
                        <div class="text">
                            <h4 class="">${item.job_name}</h4>
                            <p class="text-present" style="color: #000">${item.description}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <c:forEach var="i" begin="1" end="${item.gate}" step="1">
                                <img src="${pageContext.request.contextPath}/static/images/xx.png">
                                </c:forEach></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度  <c:forEach var="i" begin="1" end="${item.difficulty}" step="1">
                                <img src="${pageContext.request.contextPath}/static/images/xx.png">
                            </c:forEach></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${item.lifecycle}</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${item.company_need}</span>家公司需要</div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-${item.stage_one}年</div>
                                <div class="rightWarp-wages">${item.salary_one}/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">${item.stage_one}-${item.stage_two}年</div>
                                <div class="rightWarp-wages">${item.salary_two}/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">${item.stage_two}-${item.lifecycle}年</div>
                                <div class="rightWarp-wages">${item.salary_three}/月</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${item.learnings}人正在学  <datetag:date value="${item.update_at}"/></b>
                        <%--<div id="time">--%>
                            <%--<script>--%>
                                <%--setInterval("time.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);--%>
                            <%--</script>--%>
                        <%--</div>--%>

                    </div>
                    <div class="warp-class2">
                        <p class="text-p" style="color: #000000">${item.tips}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${item.job_name}</p>
                        <p class="flip-text">${item.description}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

