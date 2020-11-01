<#import "bases/common.ftl" as base>

<@base.common "AdminPanel" "/static/css/admin2.css" "">
    <div id="header">
        <div class="shell">
            <!-- Logo + Top Nav -->
            <div id="top">
                <h1><a href="#">AdminPanel</a></h1>
                <div id="top-navigation">
                    Welcome <a href="#"><strong>${user.name}</strong></a>
                    <span>|</span>
                    <a href="/logout">Log out</a>
                </div>
            </div>
            <!-- End Logo + Top Nav -->

            <!-- Main Nav -->
            <div id="navigation">
                <ul>
                    <li><a href="/adminOrganizations" class="active"><span>Организации</span></a></li>
                    <li><a href="/adminDiscounts"><span>Акции</span></a></li>
                </ul>
            </div>
            <!-- End Main Nav -->

        </div>
    </div>
    <!-- End Header -->

    <!-- Container -->
    <div id="container">
        <div class="shell">

            <br />
            <!-- Main -->
            <div id="main">
                <div class="cl">&nbsp;</div>

                <!-- Content -->
                <div id="content">

                    <!-- Box -->
                    <div class="box">
                        <div class="box">
                            <!-- Box Head -->
                            <div class="box-head">
                                <h2>Add New Organization</h2>
                            </div>
                            <!-- End Box Head -->

                            <form action="${uri}" method="post">

                                <!-- Form -->
                                <div class="form">
                                    <p>
                                        <label>Name</label>
                                        <input name="name" type="text" class="field size1" <#if org??> value="${org.name}" </#if>/>
                                        <label>Type</label>
                                        <input name="type" type="text" class="field size1" <#if org??> value="${org.type}" </#if>/>
                                        <label>Address</label>
                                        <input name="address" type="text" class="field size1" <#if org??> value="${org.address}" </#if>/>
                                    </p>
                                    <p>
                                        <span class="req">max 500 symbols</span>
                                        <label>Description</label>
                                        <textarea name="description" class="field size1" rows="10" cols="30"><#if org??>${org.description}</#if></textarea>
                                    </p>
                                    <#if org??>
                                        <input name="edit" value="${org.id}" style="display: none">
                                    </#if>

                                </div>
                                <!-- End Form -->
                                <!-- Form Buttons -->
                                <div class="buttons">
                                    <input type="submit" class="button" value="submit" />
                                </div>
                                <!-- End Form Buttons -->
                            </form>
                            <#if org??>
                                <form action="/organization-image-upload" enctype="multipart/form-data" method="post">
                                    <input name="id" style="display: none" value="${org.id}">
                                    <label>Картинка</label>
                                    <input type="file" name="image" accept=".jpg, .jpeg, .png"
                                           onchange="this.form.submit();" style="padding: 30px">
                                </form>
                            </#if>
                        </div>
                    </div>

                </div>
            </div>
            <!-- Main -->
        </div>
    </div>
</@base.common>